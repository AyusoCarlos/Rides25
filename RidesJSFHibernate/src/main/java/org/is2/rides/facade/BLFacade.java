package org.is2.rides.facade;

import org.is2.rides.dominio.User;
import org.is2.rides.dominio.Ride;

import java.util.Date;
import java.util.List;

public interface BLFacade {

    User registrarUsuario(String nombre, String email, String password);

    User login(String email, String password);

    Ride crearRide(String origen, String destino, Date fecha, int plazas, float precio, User organizador);

    List<Ride> buscarRides(String origen, String destino, Date fecha);
    
    List<Ride> obtenerRidesDeUsuario(User u);


}
