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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField temail;

    @FXML
    private PasswordField tpassword;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException {
        String email, password;
        email = temail.getText();
        password = tpassword.getText();
        Connection connection = MyDB.getInstance().getCon();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where email = '"+email+"' and password = '"+password+"' ");
        if (resultSet.next()){
            Parent root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));
            System.out.println("login");
            String roles = this.getUserRole(email);
            UserSession.getInstace(email, roles);
            System.out.println(UserSession.getInstace(email, roles));
        }
        else{
            System.out.println("error");
        }
    }
    public String getUserRole(String email) throws SQLException {
        Connection connection = MyDB.getInstance().getCon();
        Statement statement = connection.createStatement();
        String req = "SELECT roles from user where email='" + email + "'";
        ResultSet res = statement.executeQuery(req);
        String roles = null;

        while (res.next()) {
            roles = res.getString("roles");

        }

        return roles;
    }

    @FXML
    void signup(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
