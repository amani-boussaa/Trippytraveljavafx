/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trippytraveljava;

import Entities.Excursion;
import Entities.Excursioncategorie;
import Services.ExcursionService;
import Services.ExcursioncategorieService;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author amani
 */
public class Trippytraveljava {

    /**
     * @param args the command line arguments
     */
    
    /*public static void main(String[] args) {
        System.out.println("jem");
         // Excursion p1 = new Excursion(12, "Amani", "Boussaa", "progr", "tunis", "200", "2", "10.45000,32.93333");
        Excursion p2 = new Excursion(1, "test2", "tt", "progr", "tabarka", "200", "2", "15.589,20.365");
        ExcursionService ps = new ExcursionService();
ExcursioncategorieService o = new ExcursioncategorieService();
//ps.ajouter(p1);
// ps.ajouterr(p2);
//ps.supprimer(14);
// ps.modifer(p1);
 System.out.println(ps.getExcursionList().toString());
/*System.out.println(o.findById(1));

int cat = 1;
    Excursioncategorie excursioncat = null;

        ExcursioncategorieService cs = new ExcursioncategorieService();
        
        excursioncat = cs.findById(1);
        System.out.println(excursioncat.getLibelle());
    }*/
}
