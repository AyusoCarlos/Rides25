package org.is2.rides.dao;

import org.is2.rides.dominio.Ride;
import org.is2.rides.dominio.User;
import org.is2.rides.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class HibernateDataAccess {

    public User registrarUsuario(String nombre, String email, String password) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            User user = new User(nombre, email, password);
            em.persist(user);

            em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public User buscarUsuarioPorEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);

            List<User> resultados = query.getResultList();
            return resultados.isEmpty() ? null : resultados.get(0);
        } finally {
            em.close();
        }
    }

    public Ride crearRide(String origen, String destino, Date fecha, int plazas, float precio, User organizador) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Ride ride = new Ride(origen, destino, fecha, plazas, precio, organizador);
            em.persist(ride);

            em.getTransaction().commit();
            return ride;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Ride> buscarRides(String origen, String destino, Date fecha) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery("SELECT r FROM Ride r WHERE r.origen = :origen AND r.destino = :destino AND r.fecha = :fecha", Ride.class)
                     .setParameter("origen", origen)
                     .setParameter("destino", destino)
                     .setParameter("fecha", fecha)
                     .getResultList();
        } finally {
            em.close();
        }
        
        
       
    }
    
    public List<Ride> getRidesByUser(User u) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT r FROM Ride r WHERE r.organizador = :usuario", Ride.class)
                     .setParameter("usuario", u)
                     .getResultList();
        } finally {
            em.close();
        }
    }


}
