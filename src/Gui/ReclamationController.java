/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Utils.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author meche
 */
public class ReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private TextField tobjet;
    
    @FXML 
    private TextArea tdescription;
    
    @FXML
    private Label objetControl;
    
    @FXML 
    private Label descriptionControl;
    
    @FXML
    void ajouter(MouseEvent event) throws IOException{
        Connection connection = MyDB.getInstance().getCon();
        try {
            Date date1 = new Date();
            String reclamation_Date = new SimpleDateFormat("yyyy-MM-dd").format(date1);

            String objet = tobjet.getText();
            String description = tdescription.getText();
            
            String currentUserEmail = UserSession.getEmail();
            int clientId = this.getUserId(currentUserEmail);
            if (objet.length()<3){
                 objetControl.setText("3 caractères au minmum");
            }else objetControl.setText("");
            
            if (description.length()<10){
                 descriptionControl.setText("10 caractères au minmum");
            }else descriptionControl.setText("");
            
            if (objet.length()>2 && description.length()>9){
                Statement statement = connection.createStatement();
                int status = statement.executeUpdate("INSERT INTO `reclamation`(`client_id`, `type_id`, `object`, `description`, `created_at`, `status`, `seen`) VALUES ('"+clientId+"','"+1+"','"+objet+"','"+description+"','"+reclamation_Date+"','"+null+"','"+0+"')");
                if (status > 0) {
                    System.out.println("reclamation ajoutée");
                    Parent root = FXMLLoader.load(getClass().getResource("loggedIn.fxml"));
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
            }
                
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
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
