package org.is2.rides.dominio;


import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;

    private String destino;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private int numPlazas;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "organizador_id")
    @JsonBackReference
    private User organizador;

    public Ride() {
    }

    public Ride(String origen, String destino, Date fecha, int numPlazas, float precio, User organizador) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.numPlazas = numPlazas;
        this.precio = precio;
        this.organizador = organizador;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public int getNumPlazas() { return numPlazas; }
    public void setNumPlazas(int numPlazas) { this.numPlazas = numPlazas; }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }

    public User getOrganizador() { return organizador; }
    public void setOrganizador(User organizador) { this.organizador = organizador; }
}
