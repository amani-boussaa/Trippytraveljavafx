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
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ArticleCategoryAddFXMLController implements Initializable {

    @FXML
    private TextField libFld;
    @FXML
    private Button btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void insert(MouseEvent event) {
        String lib = libFld.getText();
        

        if (lib.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplissez tous les données SVP !");
            alert.showAndWait();
        } else {
            
            Category p2 = new Category(lib);
            ArticlecategoryService ps = new ArticlecategoryService();
            try {
                ps.ajouterr(p2);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setHeaderText(null);
                alert2.setContentText("Ajouté avec succés !");
                alert2.showAndWait();

            } catch (SQLException ex) {
                Logger.getLogger(ArticleCategoryAddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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
    
}
