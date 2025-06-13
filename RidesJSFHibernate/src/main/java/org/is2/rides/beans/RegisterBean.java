package org.is2.rides.beans;

import org.is2.rides.dominio.User;



import org.is2.rides.facade.BLFacade;
import org.is2.rides.facade.BLFacadeImplementation;

//import javax.enterprise.context.RequestScoped;
//import javax.inject.Named;
import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;


import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

@Named("registerBean")
@RequestScoped

public class RegisterBean {


    private String nombre;
    private String email;
    private String password;

    private BLFacade facade = new BLFacadeImplementation();

    public String registrar() {
        User nuevo = facade.registrarUsuario(nombre, email, password);
        return (nuevo != null) ? "login" : "register";
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
