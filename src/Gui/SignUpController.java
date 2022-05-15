package Gui;

import Security.BCrypt;
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
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
    private Label firstnameControl;

    @FXML
    private Label lastnameControl;

    @FXML
    private Label emailControl;

    @FXML
    private Label passwordControl;

    //String recepient = temail.getText();
    @FXML
    void signup(MouseEvent event) throws IOException, Exception {
        Connection connection = MyDB.getInstance().getCon();
        try {
            Date date1 = new Date();
            String account_Date = new SimpleDateFormat("yyyy-MM-dd").format(date1);

            String firstname = tfirstname.getText();
            String lastname = tlastname.getText();
            String email = temail.getText();
            String password = tpassword.getText();
            String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

            if (firstname.length() < 3) {
                firstnameControl.setText("3 caractères au minmum");
            } else {
                firstnameControl.setText("");
            }

            if (lastname.length() < 3) {
                lastnameControl.setText("3 caractères au minmum");
            } else {
                lastnameControl.setText("");
            }

            if (!(email.matches("(.*)@(.*)"))) {
                emailControl.setText("email non valide");
            } else {
                emailControl.setText("");
            }

            if (password.length() < 6) {
                passwordControl.setText("6 caractères au minmum");
            } else {
                passwordControl.setText("");
            }

            if (firstname.length() > 2 && lastname.length() > 2 && email.matches("(.*)@(.*)") && password.length() > 5) {
                Statement statement = connection.createStatement();
                int status = statement.executeUpdate("INSERT INTO `user`(`email`, `roles`, `password`, `is_verified`, `firstname`, `lastname`, `image`, `updated_at`, `bio`, `telephone`, `address`, `naissance`, `sexe`)"
                        + "VALUES ('" + email + "','" + "[\"ROLE_USER\"]" + "','" + hashed + "','" + 0 + "','" + firstname + "','" + lastname + "','" + null + "','" + account_Date + "','" + null + "','" + null + "','" + null + "','" + account_Date + "','" + null + "' )");
                if (status > 0) {
                    System.out.println("user registered");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Sign-Up success !");
                    alert.showAndWait();
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setScene(new Scene(root));
                }
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
