package Services;

import Entities.Maisonshotes;
import Entities.Maisonrating;
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
public class MaisonratingService {
      Connection con;
    Statement stm;

    public MaisonratingService() {
        con = MyDB.getInstance().getCon();
    }
    public void ajouterr(Maisonrating t) throws SQLException {
        //delete old records
         String req1 = "Delete from `maisonrating` WHERE `maison_id` = ? AND `user_id` = 1" ;
            PreparedStatement ps;
          try {
              ps = con.prepareStatement(req1);
          

            ps.setInt(1, t.getMaison_id());
            if (ps.executeUpdate() != 0) {
                System.out.println("maison Deleted");

            } else {
                System.out.println("id maison not found!!!");
            }
             } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
         //end delete
        String req = "INSERT INTO `maisonrating`(`maison_id`, `user_id`, `rating`) VALUES (?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, t.getMaison_id());
        pstm.setInt(2, t.getUser_id());
        pstm.setDouble(3, t.getRating());
       
        pstm.executeUpdate();

    }
     public Maisonrating findrat(Integer maison_id) {
         
         Maisonrating cat = null;
         String req = "SELECT * FROM `maisonrating` WHERE `maison_id` = " + maison_id + " AND `user_id` = 1" ;
         try {
             stm = con.createStatement();
             ResultSet rst = stm.executeQuery(req);
             System.out.println(rst.toString());
             if (rst.next()) {
                 cat = new Maisonrating();
                 cat.setId(rst.getInt("id"));
                 cat.setMaison_id(rst.getInt("maison_id"));
                 cat.setUser_id(rst.getInt("user_id"));
                 cat.setRating(Double.valueOf(rst.getInt("rating")));
                 
             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }
         return cat;
    }
}