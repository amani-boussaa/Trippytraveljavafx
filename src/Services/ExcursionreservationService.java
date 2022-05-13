package Services;

import Entities.Excursioncategorie;
import Entities.Excursionreservation;
import Gui.UserSession;
import Utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExcursionreservationService implements IService<Excursionreservation> {
    Connection con;
    Statement stm;

    public ExcursionreservationService() {
        con = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(Excursionreservation t) throws SQLException {
        String req = "INSERT INTO `excursionreservation`( `excursion_id`, `user_id`, `prix`, `status`, `created_at`, `start`, `end`, `pi`) VALUES ( '"
                + t.getExcursion_id() + "','"+t.getUser_id()+"','"+t.getPrix()+"','"+t.getStatus()+"','"+t.getCreated_at()+"','"+t.getStart()+"','"+t.getEnd()+"','"+t.getPi()+"') ";
        stm = con.createStatement();
        stm.executeUpdate(req);
    }

    @Override
    public void ajouterr(Excursionreservation t) throws SQLException {
        String req = "INSERT INTO `excursionreservation`(`excursion_id`, `user_id`, `prix`, `status`) VALUES (?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(req);
        pstm.setInt(1, t.getExcursion_id());
        pstm.setInt(2, t.getUser_id());
        pstm.setString(3, t.getPrix());
        pstm.setString(4, t.getStatus());
        pstm.executeUpdate();

    }

    @Override
    public List<Excursionreservation> afficher() throws SQLException {
        String currentUserEmail = UserSession.getEmail();
        int clientId = this.getUserId(currentUserEmail);
        String req = "Select * from `Excursionreservation` where user_id = "+clientId;
        stm = con.createStatement();
        ResultSet rst = stm.executeQuery(req);
        System.out.println(rst.toString());
        List<Excursionreservation> Excursionreservations = new ArrayList<Excursionreservation>();
        while(rst.next()){

            Excursionreservation p = new Excursionreservation(rst.getInt("id"),rst.getInt("excursion_id"),rst.getInt("user_id"),rst.getString("prix"),rst.getString("status"),rst.getString("created_at"),rst.getString("start"),rst.getString("end"),rst.getString("pi"));
            Excursionreservations.add(p);

        }
        return Excursionreservations;

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
    public void modifer(Excursionreservation p) {
        try {
            String req1 = "UPDATE `excursionreservation` SET  excursion_id=?,user_id=?,prix=?,status=?,created_at=?,start=?,end=?,pi=? where id= ?;";
            PreparedStatement ps = con.prepareStatement(req1);
            ps.setInt(1, p.getExcursion_id());
            ps.setInt(2, p.getUser_id());
            ps.setString(3, p.getPrix());
            ps.setString(4, p.getStatus());
            ps.setString(5, p.getCreated_at());
            ps.setString(6, p.getStart());
            ps.setString(7, p.getEnd());
            ps.setString(8, p.getPi());
            ps.setInt(9, p.getId());

            if (ps.executeUpdate() != 0) {
                System.out.println(" excursioncategorie updated");
            } else {
                System.out.println("non ");
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public Excursionreservation findById(Integer id) {
        System.out.println("id="+id);
        Excursionreservation r = null;
        String req = "SELECT * FROM `excursionreservation` WHERE `id` = " + id ;
        try {
            stm = con.createStatement();
            ResultSet rst = stm.executeQuery(req);
            System.out.println(rst.toString());
            if (rst.next()) {
                r = new Excursionreservation();
                r.setId(rst.getInt("id"));
                r.setPrix(rst.getString("prix"));
                r.setExcursion_id(rst.getInt("excursion_id"));
                r.setUser_id(rst.getInt("user_id"));
                r.setCreated_at(rst.getString("created_at"));
                r.setStatus(rst.getString("status"));
                r.setStart(rst.getString("start"));
                r.setEnd(rst.getString("end"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return r;
    }
     public int getUserId(String email) throws SQLException {
        Connection connection = MyDB.getInstance().getCon();
        Statement statement = connection.createStatement();
        String req = "SELECT id from user where email='" + email + "'";
        ResultSet res = statement.executeQuery(req);
        int id = 0;

        while (res.next()) {
            id = res.getInt("id");
        }

        return id;
    }
}
