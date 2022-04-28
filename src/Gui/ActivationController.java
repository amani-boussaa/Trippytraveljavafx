/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author meche
 */
public class ActivationController implements Initializable {

    @FXML
    private TextField tcode;
    
    @FXML
    void activate(MouseEvent event) throws SQLException{
        int testCode = Integer.parseInt(tcode.getText());
        int code = ActivationCode.getCode();
        String email = UserSession.getEmail();
        if (testCode == code){
            Connection connection = MyDB.getInstance().getCon();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("UPDATE user SET roles='"+"ROLE_CLIENT"+"' WHERE email='"+email+"' ");
            if(status > 0){
                System.out.println("activation success");
            }else{
                System.out.println("sql error");
            }
        }else{
            System.out.println("code incorrecte");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
