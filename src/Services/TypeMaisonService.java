/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
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



/**
 *
 * @author samar
 */
public class TypeMaisonService implements IService<TypeMaison>{
     Connection con;
    Statement stm;
    
    public  TypeMaisonService() {
     con = MyDB.getInstance().getCon();
}


    public ObservableList<String> getTypeMaisonListlibelle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter(TypeMaison t) throws SQLException {
 String req = "INSERT INTO `type_maison`( `id`, `pub`, `libelle`) VALUES ( '"
                + t.getId() + "', '" + t.getPub() + "', '" + t.getLibelle() + "', '" + t.getLibelle() + "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);    }
    

    @Override
    public void ajouterr(TypeMaison t) throws SQLException {
String req = "INSERT INTO `type_maison`(`id`, `pub`, `libelle`) VALUES (?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, t.getId());
        pstm.setInt(2, t.getPub());
        pstm.setString(3, t.getLibelle());
       
       
        pstm.executeUpdate();    
}

    @Override
    public List<TypeMaison> afficher() throws SQLException {
String req = "Select * from `type_maison`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<TypeMaison> TypeMaison = new ArrayList<TypeMaison>();
        while(rst.next()){

            TypeMaison p = new TypeMaison(rst.getInt("id"),rst.getInt("pub"),rst.getString("libelle"));
            TypeMaison.add(p);
        }
        return TypeMaison;    }

    @Override
    public void modifer(TypeMaison t) {
        try {
            String req1 = "UPDATE `maisonshotes` SET id=?, pub=?, libelle=? ;";
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setInt(1, t.getId());
            ps.setInt(2, t.getPub());
            ps.setString(3, t.getLibelle());
            
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
            String req1 ="Delete from excursion where id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);

            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                System.out.println("excursion Deleted");


            }else
                System.out.println("id excursion not found!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());


        }
    
}
     
 public ObservableList<TypeMaison> getTypemaisonList() {
        ObservableList<TypeMaison> TypeMaison = FXCollections.observableArrayList();
        String req = "Select * from `type_maison`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {

                TypeMaison p = new TypeMaison(rst.getInt("id"),  rst.getInt("pub"),rst.getString("libelle"));
                TypeMaison.add(p);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return TypeMaison;

    }
 public ObservableList<String> getTypemaisonListtLibelle() {
        ObservableList<String> TypeMaison = FXCollections.observableArrayList();
        String req = "Select * from `type_maison`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                TypeMaison.add(rst.getString("libelle"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return TypeMaison;

    }
   public TypeMaison getCategorie(String lib) {
        TypeMaison cat = null;
        String req = "SELECT * FROM `type_maison` WHERE `libelle` = '" + lib + "'";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                cat = new TypeMaison();
                cat.setId(rst.getInt("id"));
                cat.setLibelle(rst.getString("libelle"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }
public TypeMaison findById(Integer id) {
        TypeMaison cat = null;
        String req = "SELECT * FROM `type_maison` WHERE `id` = " + id ;
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                cat = new TypeMaison();
                cat.setId(rst.getInt("id"));
                cat.setLibelle(rst.getString("libelle"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }
   

   
}

