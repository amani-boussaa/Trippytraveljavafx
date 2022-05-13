/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Attraction;
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
import javafx.stage.WindowEvent;


/**
 *
 * @author cheri
 */
public class AttractionService {
    private PreparedStatement pst;
    private Statement ste ;
    private Connection connection;
    private ResultSet rs;
    
    
    
     public AttractionService() {connection=DataSource.getInstance().getConnection();
     }
     
     
    
public ObservableList<Attraction> getAllForm(){
     ObservableList<Attraction> list = FXCollections.observableArrayList();
     String requete="select * from attraction";
     Statement st;
     ResultSet rs;
   
        try {
            ste = connection.createStatement();
           rs= ste.executeQuery(requete);
            while (rs.next()) { 
                list.add(new Attraction(rs.getString("libelle"),rs.getString("localisation"),rs.getString("horraire"),rs.getInt("prix")) );              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttractionService.class.getName()).log(Level.SEVERE, null, ex);
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
            
        

     //ajout
     public void ajouterAttraction(Attraction t)  {
     String requeteInsert = "INSERT INTO attraction ( libelle , localisation , horraire, prix, image) VALUES (?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(requeteInsert);
            pst.setString(1,t.getLibelle());
            pst.setString(2,t.getLocalisation());
            pst.setString(3,t.getHorraire());
            pst.setInt(4,t.getPrix());
               pst.setString(5,"ahmed");
            pst.executeUpdate();
            System.out.println("attraction ajoute!!");
        } 
       
        catch (SQLException ex) {
           Logger.getLogger(Attraction.class.getName()).log(Level.SEVERE, null, ex);
        }
     }  
     
     
          MediaPlayer mediaPlayer;
	public void musicS() {
		String s = "library_backup\\IHEB\\ajout.mp3";
		Media h = new Media(Paths.get(s).toUri().toString());
		mediaPlayer =new MediaPlayer(h);
		mediaPlayer.play();}
     	public void musicF() {
		String s = "library_backup\\IHEB\\error.mp3";
		Media h = new Media(Paths.get(s).toUri().toString());
		mediaPlayer =new MediaPlayer(h);
		mediaPlayer.play();}
     //delete
      public void deleteAttraction(String id) {
          
        String requete = "DELETE FROM attraction WHERE libelle= '"+id+"'";
        
           try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(AttractionService.class.getName()).log(Level.SEVERE, null, ex);
        }  }

   //miseajour
  public void updateAttraction(Attraction t, String  s) {
     
        
          String requete="UPDATE attraction SET libelle = '"+t.getLibelle()+"' , localisation ='"+t.getLocalisation()+"', horraire ='"+t.getHorraire()+"', prix ='"+t.getPrix()+"' where libelle='" + s + "' ";
       try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
    
        } catch (SQLException ex) {
            Logger.getLogger(AttractionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
 

      public int Stats(String par,String field) {
   String sql = "selEct coUnt(*) from attraction where "+field+""+ "=" +"'"+par+"'";
   
  
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


