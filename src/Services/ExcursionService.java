package Services;

import Entities.Excursion;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        pstm.setString(1, t.getLibelle());
        pstm.setString(2, t.getDescription());
        pstm.setString(2, t.getProgramme());
        pstm.setString(2, t.getVille());
        pstm.setString(2, t.getPrix());
        pstm.setString(2, t.getDuration());
        pstm.setString(2, t.getLocalisation());
        pstm.executeUpdate();

    }

    @Override
    public List<Excursion> afficher() throws SQLException {
        String req = "Select * from `Excursion`";
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Excursion> Excursions = new ArrayList<Excursion>();
        while(rst.next()){

            Excursion p = new Excursion(rst.getInt("excursioncategorie_id"),rst.getString("libelle"),rst.getString("description"),rst.getString("programme"),rst.getString("ville"),rst.getString("prix"),rst.getString("duration"),rst.getString("localisation"));
            Excursions.add(p);


        }
        return Excursions;

    }
}
