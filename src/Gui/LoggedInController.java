package Gui;

import Gui.UserSession;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoggedInController implements Initializable {

    

    @FXML
    private Label label_welcome;

    @FXML private Label label_trippy;
   
    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        String email=null;
        String roles=null;
        UserSession.getInstace(email, roles).cleanUserSession();
        System.out.println(UserSession.getInstace(email, roles));
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
        
        UserSession us = new UserSession();
        us.cleanUserSession();
        
    }
    
    @FXML
    void reclamation(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
