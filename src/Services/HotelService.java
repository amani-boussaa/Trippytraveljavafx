/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataSource;
import java.io.File;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import trippytraveljava2.Entities.Hotel;



/**
 *
 * @author seifi
 */
public class HotelService {
    private PreparedStatement pst;
    private Statement ste ;
    private Connection connection;
    private ResultSet rs;
    
    
    
     public HotelService() {connection=DataSource.getInstance().getConnection();
     }
     
     
    
public ObservableList<Hotel> getAllForm(){
     ObservableList<Hotel> list = FXCollections.observableArrayList();
     String requete="select * from hotel";
     Statement st;
     ResultSet rs;
   
        try {
            ste = connection.createStatement();
           rs= ste.executeQuery(requete);
            while (rs.next()) { 
                list.add(new Hotel(rs.getString("libelle"),rs.getString("localisation"),rs.getInt("nbetoile"),rs.getInt("nbchdispo"),rs.getString("description_hotel")) );              
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


     //affichage
/*public List<Formation> readAll() throws SQLException {
List<Formation> arr=new ArrayList<>();
ste=connection.createStatement();
ResultSet rs=ste.executeQuery("select * from formation");
while (rs.next()) {

String nomeq=rs.getString("nomeq");
String domaine=rs.getString("domaine");
String duree=rs.getString("duree");
String nomform=rs.getString("nomform");
Formation ct= new Formation (nomeq,domaine,duree,nomform);
arr.add(ct);
}

return arr;
}

*/
            
         MediaPlayer mediaPlayer;
	public void music() {
                String s = "library_backup\\IHEB\\error.mp3";

                
		Media h = new Media(Paths.get(s).toUri().toString());
		mediaPlayer =new MediaPlayer(h);
		mediaPlayer.play();}
        
        public void musica() {
		String s = "library_backup\\IHEB\\ajout.mp3";
		Media h = new Media(Paths.get(s).toUri().toString());
		mediaPlayer =new MediaPlayer(h);
		mediaPlayer.play();}

     //ajout
     public void ajouterForm(Hotel t)  {
     String requeteInsert = "INSERT INTO hotel ( libelle , localisation , nbetoile, nbchdispo,description_hotel) VALUES (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(requeteInsert);
            pst.setString(1,t.getLibelle());
            pst.setString(2,t.getLocalisation());
            pst.setInt(3,t.getNbetoile());
            pst.setInt(4,t.getNbchdispo());
            pst.setString(5,t.getDescription_hotel());
            pst.executeUpdate();
            System.out.println("formation ajoute!!");
        } 
       
        catch (SQLException ex) {
           Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }  
     //delete
      public void deleteHotel(String id) {
          
        String requete = "DELETE FROM hotel WHERE libelle= '"+id+"'";
        
           try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }  }

   //miseajour
  public void updateHotel(Hotel t, String  s) {
     
        
          String requete="UPDATE hotel SET libelle = '"+t.getLibelle()+"' , localisation ='"+t.getLocalisation()+"', nbetoile ='"+t.getNbetoile()+"', nbchdispo ='"+t.getNbchdispo()+"', description_hotel ='"+t.getDescription_hotel()+"' where libelle='" + s + "' ";
       try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
    
        } catch (SQLException ex) {
            Logger.getLogger(HotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

  
     public int Stats(String par,String field) {
   String sql = "selEct coUnt(*) from HoteL where "+field+""+ "=" +"'"+par+"'";
   
  
      try {
            
    
           ste = connection.createStatement();
           rs= ste.executeQuery(sql);

            int num = 0;
            while(rs.next()){
                num = (rs.getInt(1));
                return num;
 
            }
        } catch (SQLException ex) {
            
        }
        return 0 ;
    }
}


