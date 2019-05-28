/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author NICOLAS RM
 */
public class Sesion {

    
    String user;
    String pass;
    String status;

    public Sesion(String user, String pass, String status) {
        this.user = user;
        this.pass = pass;
        this.status = status;
    }

    public Sesion() {
        
    }
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
