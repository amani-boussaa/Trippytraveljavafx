/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Article;
import Entities.Category;
import Services.ArticleService;
import Services.ArticlecategoryService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ArticleAddFXMLController implements Initializable {

    @FXML
    private TextField libFld;
   
    @FXML
    private TextField descriptionFld;
   
    @FXML
    private ComboBox<String> catCombo;

    Category excursioncat = null;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateCategories();
    }

    @FXML
    private void insert(MouseEvent event) {
        String lib = libFld.getText();
        String cat = catCombo.getSelectionModel().getSelectedItem().toString();
       
        String desc = descriptionFld.getText();
       

        if (lib.isEmpty() ||  desc.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplissez tous les données SVP !");
            alert.showAndWait();
        } else {
            ArticlecategoryService cs = new ArticlecategoryService();
            excursioncat = cs.getCategorie(cat);
            System.out.println(excursioncat);
            Article p2 = new Article(excursioncat.getId(), lib, desc);
            ArticleService ps = new ArticleService();
            try {
                ps.ajouterr(p2);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setHeaderText(null);
                alert2.setContentText("Ajouté avec succés !");
                alert2.showAndWait();

            } catch (SQLException ex) {
                Logger.getLogger(ArticleAddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void populateCategories() {
        ArticlecategoryService ps = new ArticlecategoryService();
        ObservableList<String> ExcursioncategorieList = ps.getExcursioncategorieListLibelle();
        catCombo.setItems(ExcursioncategorieList);
    }

    @FXML
    private void handleClose(MouseEvent event) {
        if (event.getSource() == btnClose) {
            // get a handle to the stage
            Stage stage = (Stage) btnClose.getScene().getWindow();
            // do what you have to do
            stage.close();
        }
    }
    @FXML
    public void handleNotifier(MouseEvent event)  {
        System.out.print("test sms");
        
              String ACCOUNT_SID = "AC5c5a9695574fe3001bc1eb38441f9adc";
              String AUTH_TOKEN = "fdca96b9198bc8ecacc2d09ca620e44e";

              Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
              Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+21699146576"),
                new com.twilio.type.PhoneNumber("+17164512977"),
                "Salut notre fidele client! Un nouveau article vient à être publier sur TrippyTravel.")
              .create();

              System.out.println(message.getSid());
          
        
    }
  

}
