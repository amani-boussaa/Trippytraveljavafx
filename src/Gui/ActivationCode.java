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
public final class ActivationCode {

    private static ActivationCode instance;
    private static int code;

    public ActivationCode() {
    }

    
    
    private ActivationCode(int code) {
        this.code = code;
    }

    public static ActivationCode getInstace(int code) {
       
            instance = new ActivationCode(code);
        
        return instance;
    }

    public static int getCode() {
        return code;
    }

    public void cleanActivationCode() {
        instance = null;
        code = 0;
        System.out.println("code = "+code);
    }

    @Override
    public String toString() {
        return "ActivationCode{"
                + "code='" + code 
                + '}';
    }   
}
