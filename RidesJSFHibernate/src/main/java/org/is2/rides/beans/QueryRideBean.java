package org.is2.rides.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.is2.rides.dominio.Ride;
import org.is2.rides.facade.BLFacade;
import org.is2.rides.facade.BLFacadeImplementation;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named("queryRideBean")
@RequestScoped
public class QueryRideBean implements Serializable {

    private String origen;
    private String destino;
    private Date fecha;

    private List<Ride> resultados;

    private transient  BLFacade facade = new BLFacadeImplementation();

    public void buscar() {
        resultados = facade.buscarRides(origen, destino, fecha);
    }

    // Getters y Setters
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public List<Ride> getResultados() { return resultados; }
}
