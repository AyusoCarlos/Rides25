package org.is2.rides.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.is2.rides.dominio.Ride;
import org.is2.rides.dominio.User;
import org.is2.rides.facade.BLFacade;
import org.is2.rides.facade.BLFacadeImplementation;

import java.io.Serializable;
import java.util.List;

@Named("myRidesBean")
@RequestScoped
public class MyRidesBean implements Serializable {

    @Inject
    private LoginBean loginBean;

    private BLFacade facade = new BLFacadeImplementation();

    public List<Ride> getMisRides() {
        User u = loginBean.getUsuarioLogueado();
        return (u != null) ? facade.obtenerRidesDeUsuario(u) : List.of();
    }
}
