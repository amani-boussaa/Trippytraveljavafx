/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author meche
 */
public final class UserSession {

    private static UserSession instance;
    private String email;
    private String roles;

    public UserSession() {
    }

    
    
    private UserSession(String email, String roles) {
        this.email = email;
        this.roles = roles;
    }

    public static UserSession getInstace(String email, String roles) {
        if (instance == null) {
            instance = new UserSession(email, roles);
        }
        return instance;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return roles;
    }

    public void cleanUserSession() {
        email = "";// or null
        roles = null;
        System.out.println("email = "+email+" roles = "+roles);
    }

    @Override
    public String toString() {
        return "UserSession{"
                + "email='" + email + '\''
                + ", roles=" + roles
                + '}';
    }   
}
