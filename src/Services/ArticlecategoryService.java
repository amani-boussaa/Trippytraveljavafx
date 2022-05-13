package Services;

import Entities.Article;
import Entities.Category;
import Utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArticlecategoryService implements IService<Category> {

    Connection con;
    Statement stm;

    public ArticlecategoryService() {
        con = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Category t) throws SQLException {
        String req = "INSERT INTO `Excursioncategorie`(`libelle`) VALUES ( '"
                + t.getLibelle() + "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void ajouterr(Category t) throws SQLException {
        String req = "INSERT INTO `category`( `name`) VALUES (?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setString(1, t.getLibelle());
        pstm.executeUpdate();

    }

    @Override
    public List<Category> afficher() throws SQLException {
        String req = "Select * from `category`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Category> Excursioncategories = new ArrayList<Category>();
        while (rst.next()) {

            Category p = new Category(rst.getInt("id"), rst.getString("name"));
            Excursioncategories.add(p);

        }
        return Excursioncategories;

    }

    public void supprimer(int id) {
        try {
            String req1 = "Delete from category where id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);

            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                System.out.println("category Deleted");

            } else {
                System.out.println("id category not found!!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifer(Category p) {
        try {
            String req1 = "UPDATE `category` SET  name=? where id= ?;";
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

    public ObservableList<Category> getExcursioncategorieList() {
        ObservableList<Category> Excursioncategories = FXCollections.observableArrayList();
        String req = "Select * from `category`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {

                Category p = new Category(rst.getInt("id"), rst.getString("name"));
                Excursioncategories.add(p);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Excursioncategories;

    }

    public ObservableList<String> getExcursioncategorieListLibelle() {
        ObservableList<String> Excursioncategories = FXCollections.observableArrayList();
        String req = "Select * from `category`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Excursioncategories.add(rst.getString("name"));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Excursioncategories;

    }

    public Category getCategorie(String lib) {
        Category cat = null;
        String req = "SELECT * FROM `category` WHERE `name` = '" + lib + "'";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                cat = new Category();
                cat.setId(rst.getInt("id"));
                cat.setLibelle(rst.getString("name"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }
    public Category findById(Integer id) {
        Category cat = null;
        String req = "SELECT * FROM `category` WHERE `id` = " + id ;
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                cat = new Category();
                cat.setId(rst.getInt("id"));
                cat.setLibelle(rst.getString("name"));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }
}
