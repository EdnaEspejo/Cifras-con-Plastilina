/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1013608348
 */
@Entity
@Table(name = "cifra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cifra.findAll", query = "SELECT c FROM Cifra c"),
    @NamedQuery(name = "Cifra.findByIdCifra", query = "SELECT c FROM Cifra c WHERE c.idCifra = :idCifra"),
    @NamedQuery(name = "Cifra.findByNombreConstruccion", query = "SELECT c FROM Cifra c WHERE c.nombreConstruccion = :nombreConstruccion"),
    @NamedQuery(name = "Cifra.findByNivel", query = "SELECT c FROM Cifra c WHERE c.nivel = :nivel"),
    @NamedQuery(name = "Cifra.findByValor", query = "SELECT c FROM Cifra c WHERE c.valor = :valor")})
public class Cifra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cifra")
    private Integer idCifra;
    
    @Size(max = 100)
    @Column(name = "nombre_construccion")
    private String nombreConstruccion;
    
    @Column(name = "nivel")
    private Integer nivel;
    
    @Column(name = "valor")
    private Integer valor;

    public Cifra() {
    }

    public Cifra(Integer idCifra) {
        this.idCifra = idCifra;
    }

    public Integer getIdCifra() {
        return idCifra;
    }

    public void setIdCifra(Integer idCifra) {
        this.idCifra = idCifra;
    }

    public String getNombreConstruccion() {
        return nombreConstruccion;
    }

    public void setNombreConstruccion(String nombreConstruccion) {
        this.nombreConstruccion = nombreConstruccion;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    
    @Override
    public String toString() {
        return "entities.Cifra[ idCifra=" + idCifra + " ]";
    }
    
}
