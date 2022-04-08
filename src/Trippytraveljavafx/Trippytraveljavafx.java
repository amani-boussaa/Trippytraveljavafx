package Trippytraveljavafx;

import Entities.Excursion;
import Services.ExcursionService;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Trippytraveljavafx {
    public static void main(String[] args) {
        Excursion p1 = new Excursion(1, "Amani", "Boussaa", "progr", "tunis", "200", "2", "10.45000,32.93333");
        Excursion p2 = new Excursion(1, "test2", "tt", "progr", "tabarka", "200", "2", "15.589,20.365");
        ExcursionService ps = new ExcursionService();

        try {
            ps.ajouter(p1);
//            ps.ajouterr(p2);
             ps.supprimer(14);
            //  ps.modifer(p1);
            System.out.println(ps.afficher().toString());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
