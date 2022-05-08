/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Excursion;
import Entities.Excursionrating;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amani
 */
public class ExcursionRatingService {
      Connection con;
    Statement stm;

    public ExcursionRatingService() {
        con = MyDB.getInstance().getCon();
    }
    public void ajouterr(Excursionrating t) throws SQLException {
        //delete old records
         String req1 = "Delete from `excursionrating` WHERE `excursion_id` = ? AND `user_id` = 1" ;
            PreparedStatement ps;
          try {
              ps = con.prepareStatement(req1);
          

            ps.setInt(1, t.getExcursion_id());
            if (ps.executeUpdate() != 0) {
                System.out.println("excursion Deleted");

            } else {
                System.out.println("id excursion not found!!!");
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
         //end delete
        String req = "INSERT INTO `excursionrating`(`excursion_id`, `user_id`, `rating`) VALUES (?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, t.getExcursion_id());
        pstm.setInt(2, t.getUser_id());
        pstm.setDouble(3, t.getRating());
       
        pstm.executeUpdate();

    }
     public Excursionrating findrat(Integer excursion_id) {
         
         Excursionrating cat = null;
         String req = "SELECT * FROM `excursionrating` WHERE `excursion_id` = " + excursion_id + " AND `user_id` = 1" ;
         try {
             stm = con.createStatement();
             ResultSet rst = stm.executeQuery(req);
             System.out.println(rst.toString());
             if (rst.next()) {
                 cat = new Excursionrating();
                 cat.setId(rst.getInt("id"));
                 cat.setExcursion_id(rst.getInt("excursion_id"));
                 cat.setUser_id(rst.getInt("user_id"));
                 cat.setRating(Double.valueOf(rst.getInt("rating")));
                 
             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         return cat;
    }
}
