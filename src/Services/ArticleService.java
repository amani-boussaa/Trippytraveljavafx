package Services;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import Entities.Chartexcursion;
import Entities.Article;
import Entities.Category;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ArticleService implements IService<Article> {

    Connection con;
    Statement stm;

    public ArticleService() {
        con = MyDB.getInstance().getCon();
    }
Date date = Calendar.getInstance().getTime();  
                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
                String strDate = dateFormat.format(date);  
    @Override
    public void ajouter(Article t) throws SQLException {
        String req = "INSERT INTO `article`( `id_category_id`, `title`, `content`,`created_at`) VALUES ( '"
                + t.getExcursioncategorie_id() + "', '" + t.getLibelle() + "', '" + t.getDescription() + "', '" + t.created_at + "') ";
        stm = con.createStatement();
        stm.executeUpdate(req);
    }

     
    @Override
    public void ajouterr(Article t) throws SQLException {
        String req = "INSERT INTO `article`(`id_category_id`, `title`, `content`, `created_at`) VALUES (?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, t.getExcursioncategorie_id());
        pstm.setString(2, t.getLibelle());
        pstm.setString(3, t.getDescription());
        pstm.setDate(4,  t.created_at);
        pstm.executeUpdate();

    }

    /*@Override
    public List<Excursion> afficher() throws SQLException {
        String req = "Select * from `Article`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Excursion> Excursions = new ArrayList<Excursion>();
        while (rst.next()) {

            Article p = new Article(rst.getInt("excursioncategorie_id"), rst.getString("libelle"), rst.getString("description"), rst.getString("programme"), rst.getString("ville"), rst.getString("prix"), rst.getString("duration"), rst.getString("localisation"));
             Excursions.add(p);

        }
        return Excursions;

    }*/
    @Override
    public List<Article> afficher() throws SQLException {
        List<Article> list = new ArrayList<>();
        try {
            String req = "select * from article";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Article p = new Article();
                p.setId(rs.getInt("id"));
                p.setLibelle(rs.getString("title"));
                
                p.setImgSrc("/img/kiwi.png");
                p.setColor("6A7324");
                list.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public ObservableList<Article> getExcursionList() {
        ObservableList<Article> Excursions = FXCollections.observableArrayList();
        String req = "Select * from `article`";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Article p = new Article(rst.getInt("id"),rst.getInt("views"), rst.getInt("id_category_id"), rst.getString("title"), rst.getString("content"));
                System.out.println(p.toString());
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
            String req1 = "Delete from article where id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);

            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                System.out.println("article Deleted");

            } else {
                System.out.println("id article not found!!!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void modifer(Article p) {
        try {
            String req1 = "UPDATE `article` SET id_category_id=?, title=?, content=? WHERE id=? ;";
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setInt(1, p.getExcursioncategorie_id());
            ps.setString(2, p.getLibelle());
            ps.setString(3, p.getDescription());
            ps.setInt(4, p.getId());

            if (ps.executeUpdate() != 0) {
                System.out.println(" article updated");
            } else {
                System.out.println("non ");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ObservableList<Chartexcursion> chartcategorie() {
        ObservableList<Chartexcursion> Excursions = FXCollections.observableArrayList();
        String req = "SELECT id_category_id, COUNT(*) as count FROM article GROUP BY id_category_id";
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            while (rst.next()) {
                Chartexcursion p = new Chartexcursion(rst.getInt("id_category_id"), rst.getInt("count"));

                Excursions.add(p);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(Excursions);
        return Excursions;

    }

    public Article findById(Integer id) {
        Article cat = null;
        String req = "SELECT * FROM `article` WHERE `id` = " + id;
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                cat = new Article();
                cat.setId(rst.getInt("id"));
                cat.setLibelle(rst.getString("title"));
               
                cat.setImgSrc("/img/kiwi.png");
                cat.setColor("6A7324");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cat;
    }

}
