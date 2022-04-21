package Services;

import Entities.Excursion;
import Entities.Excursioncategorie;
import Utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExcursioncategorieService implements IService<Excursioncategorie>{
    Connection con;
    Statement stm;

    public ExcursioncategorieService() {
        con = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Excursioncategorie t) throws SQLException {
        String req = "INSERT INTO `Excursioncategorie`(`libelle`) VALUES ( '"
                + t.getLibelle() + "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void ajouterr(Excursioncategorie t) throws SQLException {
        String req = "INSERT INTO `Excursioncategorie`( `libelle`) VALUES (?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setString(1, t.getLibelle());
        pstm.executeUpdate();

    }

    @Override
    public List<Excursioncategorie> afficher() throws SQLException {
        String req = "Select * from `Excursioncategorie`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Excursioncategorie> Excursioncategories = new ArrayList<Excursioncategorie>();
        while(rst.next()){

            Excursioncategorie p = new Excursioncategorie(rst.getInt("id"),rst.getString("libelle"));
            Excursioncategories.add(p);

        }
        return Excursioncategories;

    }

    public void supprimer(int id) {
        try {
            String req1 ="Delete from excursioncategorie where id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);

            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                System.out.println("excursioncategorie Deleted");


            }else
                System.out.println("id excursioncategorie not found!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());


        }
    }

    @Override
    public void modifer(Excursioncategorie p) {
        try {
            String req1 = "UPDATE `excursioncategorie` SET  libelle=? where id= ?;";
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setString(1, p.getLibelle());
            ps.setInt(2, p.getId());

            if (ps.executeUpdate() != 0) {
                System.out.println(" excursioncategorie updated");
            } else {
                System.out.println("non ");
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ObservableList<Excursioncategorie> getExcursioncategorieList() {
        ObservableList<Excursioncategorie> Excursioncategories = FXCollections.observableArrayList();
        String req = "Select * from `excursioncategorie`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {

                Excursioncategorie p = new Excursioncategorie(rst.getInt("id"),rst.getString("libelle"));
                Excursioncategories.add(p);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Excursioncategories;

    }
     public ObservableList<String> getExcursioncategorieListLibelle() {
        ObservableList<String> Excursioncategories = FXCollections.observableArrayList();
        String req = "Select * from `excursioncategorie`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Excursioncategories.add(rst.getString("libelle"));
               

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Excursioncategories;

    }
}
