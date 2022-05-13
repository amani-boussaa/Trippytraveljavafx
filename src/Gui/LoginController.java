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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LoginController implements Initializable {

    @FXML
    private TextField temail;

    @FXML
    private PasswordField tpassword;
    
    @FXML
    private Label loginTest;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException, Exception {
        String email, password, hashed;
        Boolean testpw;
        email = temail.getText();
        password = tpassword.getText();
        hashed = this.getUserPassword(email);
        if (BCrypt.checkpw(password, hashed)){
            testpw =true;
            System.out.println("matches");
        }
        else{
            testpw =false;
            System.out.println("not matches");
        }
        
        Connection connection = MyDB.getInstance().getCon();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user where email = '"+email+"' ");
        if (resultSet.next()&& BCrypt.checkpw(password, hashed)){
            if(this.getUserRole(email).equalsIgnoreCase("ROLE_ADMIN") || this.getUserRole(email).equalsIgnoreCase("[\"ROLE_ADMIN\"]")){
                Parent root = FXMLLoader.load(getClass().getResource("ExcursionFXML.fxml"));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
                System.out.println("login admin");
                String roles = this.getUserRole(email);
                UserSession.getInstace(email, roles);
                System.out.println(UserSession.getInstace(email, roles));
            }
            else if (this.getUserRole(email).equalsIgnoreCase("ROLE_USER") || this.getUserRole(email).equalsIgnoreCase("[\"ROLE_USER\"]")) {
                this.sendMail(email);
                Parent root = FXMLLoader.load(getClass().getResource("Activation.fxml"));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
                System.out.println("login client");
                String roles = this.getUserRole(email);
                UserSession.getInstace(email, roles);
                System.out.println(UserSession.getInstace(email, roles));
            }
            else {
                Parent root = FXMLLoader.load(getClass().getResource("MarketExcursionFXML.fxml"));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
                System.out.println("login client");
                String roles = this.getUserRole(email);
                UserSession.getInstace(email, roles);
                System.out.println(UserSession.getInstace(email, roles));
            }
        }
        else{
            loginTest.setText("email out mot de passe incorrecte");
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
            roles= res.getString("roles");
        }

        return roles;
    }
    
    public String getUserPassword(String email) throws SQLException {
        Connection connection = MyDB.getInstance().getCon();
        Statement statement = connection.createStatement();
        String req = "SELECT password from user where email='" + email + "'";
        ResultSet res = statement.executeQuery(req);
        String password = null;

        while (res.next()) {
            password = res.getString("password");

        }

        return password;
    }

    @FXML
    void signup(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    void forget(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Recuperation.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
    
    public static void sendMail(String recepient) throws Exception{
        System.out.println("trying to send email");
        
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String senderEmail = "mecherguihamdi45@gmail.com";
        String senderPassword = "ydgbqptuqmkktmjj";
        
        Session session = Session.getInstance(properties, new Authenticator(){
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        
        Message message = prepareMessage(session, senderEmail, recepient);
        Transport.send(message);
        System.out.println("mail sent successfully");
    }
    
    private static Message prepareMessage(Session session, String senderEmail, String recepient) {
            
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("account verfication");
            Random random = new Random();
            int code = random.nextInt(99999999);
            message.setText("code : " + code);
            ActivationCode.getInstace(code);
            System.out.println("instance code = "+ActivationCode.getCode());
            return message;
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
