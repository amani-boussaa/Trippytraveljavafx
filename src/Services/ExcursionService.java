package Services;

import Entities.Chartexcursion;
import Entities.Excursion;
import Entities.Excursioncategorie;
import Utils.MyDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExcursionService implements IService<Excursion> {

    Connection con;
    Statement stm;

    public ExcursionService() {
        con = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Excursion t) throws SQLException {
        String req = "INSERT INTO `excursion`( `excursioncategorie_id`, `libelle`, `description`, `programme`, `ville`, `prix`, `duration`, `localisation`) VALUES ( '"
                + t.getExcursioncategorie_id() + "', '" + t.getLibelle() + "', '" + t.getDescription() + "', '" + t.getProgramme() + "', '" + t.getVille() + "', '" + t.getPrix() + "', '" + t.getDuration() + "', '" + t.getLocalisation() + "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void ajouterr(Excursion t) throws SQLException {
        String req = "INSERT INTO `excursion`(`excursioncategorie_id`, `libelle`, `description`, `programme`, `ville`, `prix`, `duration`, `localisation`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, t.getExcursioncategorie_id());
        pstm.setString(2, t.getLibelle());
        pstm.setString(3, t.getDescription());
        pstm.setString(4, t.getProgramme());
        pstm.setString(5, t.getVille());
        pstm.setString(6, t.getPrix());
        pstm.setString(7, t.getDuration());
        pstm.setString(8, t.getLocalisation());
        pstm.executeUpdate();

    }

    /*@Override
    public List<Excursion> afficher() throws SQLException {
        String req = "Select * from `Excursion`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Excursion> Excursions = new ArrayList<Excursion>();
        while (rst.next()) {

            Excursion p = new Excursion(rst.getInt("excursioncategorie_id"), rst.getString("libelle"), rst.getString("description"), rst.getString("programme"), rst.getString("ville"), rst.getString("prix"), rst.getString("duration"), rst.getString("localisation"));
             Excursions.add(p);

        }
        return Excursions;

    }*/
    @Override
    public List<Excursion> afficher() throws SQLException {
        List<Excursion> list = new ArrayList<>();
        try {
            String req = "select * from excursion";
            //String req = "SELECT * FROM excursion INNER JOIN excursionimage ON excursion.id=excursionimage.excursion_id GROUP BY excursion.id";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Excursion p = new Excursion();
                p.setId(rs.getInt("id"));
                p.setLibelle(rs.getString("libelle"));
                p.setPrix(rs.getString("prix"));
                p.setImgSrc("/img/kiwi.png");
                p.setColor("2ebdc4");   
                

                list.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public ObservableList<Excursion> getExcursionList() {
        ObservableList<Excursion> Excursions = FXCollections.observableArrayList();
        String req = "Select * from `Excursion`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Excursion p = new Excursion(rst.getInt("id"), rst.getInt("excursioncategorie_id"), rst.getString("libelle"), rst.getString("description"), rst.getString("programme"), rst.getString("ville"), rst.getString("prix"), rst.getString("duration"), rst.getString("localisation"));

                Excursions.add(p);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(Excursions);
        return Excursions;

    }

    public void supprimer(int id) {
        try {
            String req1 = "Delete from excursion where id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);

            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                System.out.println("excursion Deleted");

            } else {
                System.out.println("id excursion not found!!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifer(Excursion p) {
        try {
            String req1 = "UPDATE `excursion` SET excursioncategorie_id=?, libelle=?, description=? ,programme=? , ville=?,prix=?,duration=?,localisation=? where id= ?;";
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setInt(1, p.getExcursioncategorie_id());
            ps.setString(2, p.getLibelle());
            ps.setString(3, p.getDescription());
            ps.setString(4, p.getProgramme());
            ps.setString(5, p.getVille());
            ps.setString(6, p.getPrix());
            ps.setString(7, p.getDuration());
            ps.setString(8, p.getLocalisation());
            ps.setInt(9, p.getId());

            if (ps.executeUpdate() != 0) {
                System.out.println(" excursion updated");
            } else {
                System.out.println("non ");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<Chartexcursion> chartcategorie() {
        ObservableList<Chartexcursion> Excursions = FXCollections.observableArrayList();
        String req = "SELECT excursioncategorie_id, COUNT(*) as count FROM excursion GROUP BY excursioncategorie_id";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Chartexcursion p = new Chartexcursion(rst.getInt("excursioncategorie_id"), rst.getInt("count"));

                Excursions.add(p);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(Excursions);
        return Excursions;

    }

    public Excursion findById(Integer id) {
        Excursion cat = null;
        String req = "SELECT * FROM `excursion` WHERE `id` = " + id;
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                cat = new Excursion();
                cat.setId(rst.getInt("id"));
                cat.setLibelle(rst.getString("libelle"));
                cat.setPrix(rst.getString("prix"));
                cat.setImgSrc("/img/kiwi.png");
                cat.setColor("6A7324");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }

}
