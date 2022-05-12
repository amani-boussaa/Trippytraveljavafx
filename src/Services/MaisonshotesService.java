/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Maisonshotes;
import Entities.TypeMaison;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class MaisonshotesService implements IService<Maisonshotes> {
    Connection con;
    Statement stm;

public  MaisonshotesService() {
     con = MyDB.getInstance().getCon();
     System.out.println("jj");
}

    @Override
    public void ajouter(Maisonshotes t) throws SQLException {
 String req = "INSERT INTO `maisonshotes`( `capacite`, `nbrChambres`, `typeMaison_id`, `libelle`, `localisation`, `proprietaire`, `prix`) VALUES ( '"
                + t.getCapacite() + "', '" + t.getNbrChambres() + "', '" + t.getTypeMaison_id() + "', '" + t.getLibelle() + "', '" + t.getLocalisation() + "', '" + t.getProprietaire() + "', '" + t.getPrix() + "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);    }

    @Override
    public void ajouterr(Maisonshotes t) throws SQLException {
       String req = "INSERT INTO `maisonshotes`(`capacite`, `nbrChambres`, `typeMaison_id`, `libelle`, `localisation`, `proprietaire`, `prix`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setString(1, t.getCapacite());
        pstm.setString(2, t.getNbrChambres());
        pstm.setInt(3, t.getTypeMaison_id());
        pstm.setString(4, t.getLibelle());
        pstm.setString(5, t.getLocalisation());
        pstm.setString(6, t.getProprietaire());
        pstm.setString(7, t.getPrix());
       
        pstm.executeUpdate();
    }

    @Override
    public List<Maisonshotes> afficher() throws SQLException {
           String req = "Select * from `maisonshotes`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Maisonshotes> Maisonshotes = new ArrayList<Maisonshotes>();
        while(rst.next()){

            Maisonshotes p = new Maisonshotes(rst.getString("capacite"),rst.getString("nbrChambres"),rst.getInt("typeMaison_id"),rst.getString("libelle"),rst.getString("localisation"),rst.getString("proprietaire"),rst.getString("prix"));
            Maisonshotes.add(p);
        }
        return Maisonshotes;

    }

    @Override
    public void modifer(Maisonshotes t) {
 try {
            String req1 = "UPDATE `maisonshotes` SET capacite=?, nbrChambres=?, typeMaison_id=? ,libelle=? , localisation=?,proprietaire=?;";
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setString(1, t.getCapacite());
            ps.setString(2, t.getNbrChambres());
            ps.setInt(3, t.getTypeMaison_id());
            ps.setString(4, t.getLocalisation());
            ps.setString(5, t.getProprietaire());
            ps.setString(6, t.getPrix());
           
            ps.setInt(9, t.getId());

            if (ps.executeUpdate() != 0) {
                System.out.println(" maisons updated");
            } else {
                System.out.println("non ");
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
 

    @Override
   public void supprimer(int id) {
        try {
            String req1 ="Delete from maisonshotes where id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);

            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                System.out.println("maison Deleted");


            }else
                System.out.println("id maison not found!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());


        }
    }
public ObservableList<Maisonshotes> getMaisonsList() {
        ObservableList<Maisonshotes> Maisonshotes = FXCollections.observableArrayList();
        String req = "Select * from `maisonshotes`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Maisonshotes p = new Maisonshotes(rst.getInt("id"),rst.getString("capacite"), rst.getString("nbr_chambres"), rst.getInt("type_maison_id"), rst.getString("libelle"), rst.getString("localisation"), rst.getString("proprietaire"), rst.getString("prix"));
              System.out.println(p);
                Maisonshotes.add(p);
                

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(Maisonshotes);
        return Maisonshotes;

    }
 
   
}
