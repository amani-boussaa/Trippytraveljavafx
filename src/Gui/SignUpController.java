package Gui;

import Utils.MyDB;
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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private TextField tfirstname;

    @FXML
    private TextField tlastname;

    @FXML
    private TextField temail;

    @FXML
    private PasswordField tpassword;

    @FXML
    void signup(MouseEvent event){
        Connection connection = MyDB.getInstance().getCon();
        try {
            Date date1 = new Date();
            String account_Date = new SimpleDateFormat("yyyy-MM-dd").format(date1);

            String firstname = tfirstname.getText();
            String lastname = tlastname.getText();
            String email = temail.getText();
            String password = tpassword.getText();
            Statement statement = connection.createStatement();
            int status = statement.executeUpdate("INSERT INTO `user`(`email`, `roles`, `password`, `is_verified`, `firstname`, `lastname`, `image`, `updated_at`, `bio`, `telephone`, `address`, `naissance`, `sexe`)"
                    + "VALUES ('"+email+"','"+null+"','"+password+"','"+0+"','"+firstname+"','"+lastname+"','"+null+"','"+account_Date+"','"+null+"','"+null+"','"+null+"','"+account_Date+"','"+null+"' )");

            if (status > 0) {
                System.out.println("user registered");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void login(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
