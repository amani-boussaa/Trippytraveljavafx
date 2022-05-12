/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Attraction;
import Entities.CategorieAttraction;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cheri
 */
public class CategorieAttractionService {
    private PreparedStatement pst;
    private Statement ste ;
    private Connection connection;
    private ResultSet rs;
    
    
    
     public CategorieAttractionService() {connection=DataSource.getInstance().getConnection();
     }
     
     
    
public ObservableList<CategorieAttraction> getAllForm(){
     ObservableList<CategorieAttraction> list = FXCollections.observableArrayList();
     String requete="select * from categorie_attraction";
     Statement st;
     ResultSet rs;
   
        try {
            ste = connection.createStatement();
           rs= ste.executeQuery(requete);
            while (rs.next()) { 
                list.add(new CategorieAttraction(rs.getString("libelle"),rs.getBoolean("contrainteAge")));              
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategorieAttractionService.class.getName()).log(Level.SEVERE, null, ex);
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
     public void ajouterCategorieAttraction(CategorieAttraction t)  {
     String requeteInsert = "INSERT INTO categorie_attraction ( libelle , contrainteAge) VALUES (?,?)";
        try {
            pst = connection.prepareStatement(requeteInsert);
            pst.setString(1,t.getLibelle());
            pst.setBoolean(2,t.getcontrainteAge());
            pst.executeUpdate();
            System.out.println("categorie ajoute!!");
        } 
       
        catch (SQLException ex) {
           Logger.getLogger(CategorieAttraction.class.getName()).log(Level.SEVERE, null, ex);
        }
     }  
     //delete
      public void deleteCategorieAttraction(String id) {
          
        String requete = "DELETE FROM categorie_attraction WHERE libelle= '"+id+"'";
        
           try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(CategorieAttractionService.class.getName()).log(Level.SEVERE, null, ex);
        }  }

   //miseajour
  public void updateCategorieAttraction(CategorieAttraction t, String  s) {
     
        
          String requete="UPDATE categorie_attraction SET libelle = '"+t.getLibelle()+"' , contrainteAge ='"+t.getcontrainteAge()+"' where libelle='" + s + "' ";
       try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
    
        } catch (SQLException ex) {
            Logger.getLogger(CategorieAttractionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

  
    
}
