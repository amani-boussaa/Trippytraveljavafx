/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * FXML Controller class
 *
 * @author meche
 */
public class RecuperationController implements Initializable {
    
    @FXML
    private TextField temail;
    
    @FXML
    void send(MouseEvent event) throws IOException, Exception{
        String email = temail.getText();
        this.sendMail(email);
        UserSession.getInstace(email, null);
        Parent root = FXMLLoader.load(getClass().getResource("newPassword.fxml"));
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
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}
