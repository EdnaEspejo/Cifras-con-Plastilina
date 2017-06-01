/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entities.Cifra;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 1013608348
 */
@Stateless
@Path("entities.cifra")
public class CifraFacadeREST extends AbstractFacade<Cifra> {
    @PersistenceContext(unitName = "CifrasplastilinaPU")
    private EntityManager em;

    public CifraFacadeREST() {
        super(Cifra.class);
    }

    /* Crea un dato Cifra
     * Se prueba con el TestCase "Crear" del proyecto Cifra-soapui-project
     * @param entity Entidad Cifra
     * @return JSON con la respuesta satisfactoria o insatisfactoria
     */
    @POST
    @Path("create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String createCifra(Cifra entity) {
        String result;
        try{
            em.persist(entity);
            result = "{'response':'Cifra create']";
        }catch(Exception e){
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));            
            result = "{'response':'Error', 'cause':'"+errors.toString()+"'}";
        }
        return result;
    }

    
    /**
     * Edita un campo de acuerdo al id que recibe
     * Se prueba con el TestCase "Editar" del proyecto Cifra-soapui-project
     * @param entity Entidad Cifra
     * @return JSON con la respuesta satisfactorio o insatisfactorio
     */
    @POST
    @Path("edit")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public String editCifra(Cifra entity) {
        try{
            if(entity.getIdCifra() != 0){
                Cifra cifra = super.find(entity.getIdCifra());
                if(cifra == null){
                    return "{'response':'Error','cause':'Cifra not found'}";
                }else{
                    if(entity.getIdCifra() != 0) cifra.setIdCifra(entity.getIdCifra());
                    if(entity.getNombreConstruccion() != null) cifra.setNombreConstruccion(entity.getNombreConstruccion());
                    if(entity.getNivel()!= null) cifra.setNivel(entity.getNivel());
                    if(entity.getValor()!= null) cifra.setValor(entity.getValor());
                    
                    em.merge(cifra);
                    
                    return "{'response':'Cifra modificated'}";
                }
            }else{
                return "{'response':'Error','cause':'Not send Id'}";
            }
        }catch (Exception e){
            return "{'response':'Error','cause':'Exception'}";
        }
    }
    
    
    /**
     * Al consumir, arroja un json con todos los datos de la tabla
     * Se prueba con el TestCase "ListarTodo" del proyecto Cifra-soapui-project
     * @return String con todos los Cifra
     */ 
    
    @GET
    @Path("listCifras")
    @Produces({"application/json"})
    public String listCifa(){
        String result = "[";
        Query query = em.createQuery("SELECT c FROM Cifra c");
        List<Cifra> datos = query.getResultList();
        for (int i = 0; i < datos.size(); i++) {
            result += "{";
            if(i == datos.size()-1){
                result += "{\"idCifra\""+datos.get(i).getIdCifra()+":\",\"nombreConstruccion\":\""+datos.get(i).getNombreConstruccion()+":\",\"nivel\":\""+datos.get(i).getNivel()+":\",\"valor\":\""+datos.get(i).getValor();
            }else{
                result += "'idCifra':'"+datos.get(i).getIdCifra()+"', 'nombreConstruccion':'"+datos.get(i).getNombreConstruccion()+"', 'nivel':'"+datos.get(i).getNivel()+"', 'valor':'"+datos.get(i).getValor();
            }
        }
        return result += "]";
    }
    
    
    @GET
    @Override
    @Produces({"application/json"})
    public List<Cifra> findAll() {
        Cifra cifra = new Cifra();
        List<Cifra> list = new ArrayList<>();
        list.add(cifra);
        return list;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Cifra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
