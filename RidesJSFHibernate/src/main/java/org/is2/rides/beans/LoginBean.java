package org.is2.rides.beans;

import org.is2.rides.dominio.User;

import org.is2.rides.facade.BLFacade;
import org.is2.rides.facade.BLFacadeImplementation;

//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;
import java.io.Serializable;


import jakarta.inject.Named;
//import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;


@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String password;
    private User usuarioLogueado;

    private BLFacade facade = new BLFacadeImplementation();

    public String login() {
        usuarioLogueado = facade.login(email, password);
        return (usuarioLogueado != null) ? "home" : "error";
    }

    public String logout() {
        usuarioLogueado = null;
        email = null;
        password = null;
        return "/Login.xhtml?faces-redirect=true";

    }

    public boolean isLogueado() {
        return usuarioLogueado != null;
    }

    public User getUsuarioLogueado() {
        return usuarioLogueado;
    }

    // Getters y setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
