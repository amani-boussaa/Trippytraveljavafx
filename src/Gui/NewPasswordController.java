
package Gui;

import Security.BCrypt;
import Utils.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author meche
 */
public class NewPasswordController implements Initializable {

    @FXML
    private TextField tmailCode;
    
    @FXML
    private PasswordField tnewPassword;
    
    @FXML
    void updatePassword(MouseEvent event) throws IOException, SQLException {
        int mailCode = Integer.parseInt(tmailCode.getText());
        String newPassword = tnewPassword.getText();
        String hashed = BCrypt.hashpw(newPassword, BCrypt.gensalt(12));
        int code = ActivationCode.getCode();
        String email = UserSession.getEmail();
        if (mailCode == code){
            Connection connection = MyDB.getInstance().getCon();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("UPDATE user SET password='"+hashed+"' WHERE email='"+email+"' ");
            if(status > 0){
                System.out.println("update password success");
                email=null;
                String roles=null;
                UserSession.getInstace(email, roles).cleanUserSession();
                System.out.println(UserSession.getInstace(email, roles));
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
            }else{
                System.out.println("sql error");
            }
        }else{
            System.out.println("code incorrecte");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
}
