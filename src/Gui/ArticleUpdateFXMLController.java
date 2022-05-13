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
public class ArticleUpdateFXMLController implements Initializable {

    @FXML
    private TextField libFld;
   
    @FXML
    private TextField descriptionFld;
    
    int studentId;
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
    private void update(MouseEvent event) {
        String lib = libFld.getText();
        String cat = catCombo.getSelectionModel().getSelectedItem().toString();
        
        String desc = descriptionFld.getText();
        
        ArticlecategoryService cs = new ArticlecategoryService();
        excursioncat = cs.getCategorie(cat);
        Article p2 = new Article(studentId, excursioncat.getId(), lib, desc);
        ArticleService ps = new ArticleService();
        ps.modifer(p2);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setHeaderText(null);
        alert2.setContentText("Modifié avec succés !");
        alert2.showAndWait();
    }

    void setTextField(int id, String lib, int cat, String desc) {

        studentId = id;
        libFld.setText(lib);
        
        descriptionFld.setText(desc);
        
        /**set selected categori**/
        ArticlecategoryService cs = new ArticlecategoryService();
        excursioncat = cs.findById(cat);
        catCombo.setValue(excursioncat.getLibelle());
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

}
