/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.regex.Pattern;

/**
 *
 * @author amani
 */
public class ControleInputsService {
    public  boolean isNumeric(String string) {
    int intValue;
		
    System.out.println(String.format("Parsing string: \"%s\"", string));
		
    if(string == null || string.equals("")) {
        System.out.println("String cannot be parsed, it is null or empty.");
        return false;
    }
    
    try {
        //intValue = Integer.parseInt(string);
        double d = Double.parseDouble(string);
    } catch (NumberFormatException e) {
        System.out.println("Input String cannot be parsed to Integer.");
        return false;
    }
     return true;
}
}
