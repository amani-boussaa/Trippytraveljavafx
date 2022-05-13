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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author meche
 */
public class ActivationController implements Initializable {

    @FXML
    private TextField tcode;
    
    @FXML
    private Label controleCode;
    
    @FXML
    void activate(MouseEvent event) throws SQLException, IOException{
        int testCode = Integer.parseInt(tcode.getText());
        int code = ActivationCode.getCode();
        String email = UserSession.getEmail();
        if (testCode == code){
            Connection connection = MyDB.getInstance().getCon();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("UPDATE user SET roles='"+"ROLE_CLIENT"+"' WHERE email='"+email+"' ");
            if(status > 0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("activation success !");
                    alert.showAndWait();
                System.out.println("activation success");
                Parent root = FXMLLoader.load(getClass().getResource("loggedIn.fxml"));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
            }else{
                System.out.println("sql error");
            }
        }else{
            controleCode.setText("invalid code");
            System.out.println("code incorrecte");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
