package org.is2.rides.beans;

import org.is2.rides.dominio.Ride;
import org.is2.rides.facade.BLFacade;
import org.is2.rides.facade.BLFacadeImplementation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

@Named("rideBean")
@RequestScoped
public class RideBean {

    private String origen;
    private String destino;
    private Date fecha;
    private int plazas;
    private float precio;

    private List<Ride> resultados;

    private BLFacade facade = new BLFacadeImplementation();

    @Inject
    private LoginBean loginBean;

    public String crear() {
        if (!loginBean.isLogueado()) return "login";
        facade.crearRide(origen, destino, fecha, plazas, precio, loginBean.getUsuarioLogueado());
        return "home";
    }

    public String buscar() {
        resultados = facade.buscarRides(origen, destino,fecha);
        return "resultados";
    }

    // Getters y setters
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public int getPlazas() { return plazas; }
    public void setPlazas(int plazas) { this.plazas = plazas; }

    public float getPrecio() { return precio; }
    public void setPrecio(float precio) { this.precio = precio; }

    public List<Ride> getResultados() { return resultados; }
}
