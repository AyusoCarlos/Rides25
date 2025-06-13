package org.is2.rides.facade;

import org.is2.rides.dao.HibernateDataAccess;
import org.is2.rides.dominio.User;
import org.is2.rides.dominio.Ride;

import java.util.Date;
import java.util.List;

public class BLFacadeImplementation implements BLFacade {

    private HibernateDataAccess dao = new HibernateDataAccess();

    @Override
    public User registrarUsuario(String nombre, String email, String password) {
        return dao.registrarUsuario(nombre, email, password);
    }

    @Override
    public User login(String email, String password) {
        User user = dao.buscarUsuarioPorEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public Ride crearRide(String origen, String destino, Date fecha, int plazas, float precio, User organizador) {
        return dao.crearRide(origen, destino, fecha, plazas, precio, organizador);
    }

    @Override
    public List<Ride> buscarRides(String origen, String destino, Date fecha) {
        return dao.buscarRides(origen, destino, fecha);
    }
    
    
    @Override
    public List<Ride> obtenerRidesDeUsuario(User u) {
        return dao.getRidesByUser(u);
    }


}
