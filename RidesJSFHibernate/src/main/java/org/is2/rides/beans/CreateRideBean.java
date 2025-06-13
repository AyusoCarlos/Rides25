package org.is2.rides.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.is2.rides.dominio.Ride;
import org.is2.rides.dominio.User;
import org.is2.rides.facade.BLFacade;
import org.is2.rides.facade.BLFacadeImplementation;

import java.io.Serializable;
import java.util.Date;

@Named("createRideBean")
@RequestScoped
public class CreateRideBean implements Serializable {

    private String origen;
    private String destino;
    private Date fecha;
    private int numPlazas;
    private float precio;

    @Inject
    private LoginBean loginBean;

    private BLFacade facade = new BLFacadeImplementation();

    public String crear() {
        User organizador = loginBean.getUsuarioLogueado();
        Ride r = facade.crearRide(origen, destino, fecha, numPlazas, precio, organizador);
        return (r != null) ? "home" : "CreateRide.xhtml";
    }

    // Getters y setters
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
}
