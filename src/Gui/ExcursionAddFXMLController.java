/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursion;
import Entities.Excursioncategorie;
import Services.ExcursionService;
import Services.ExcursioncategorieService;
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
public class ExcursionAddFXMLController implements Initializable {

    @FXML
    private TextField libFld;
    @FXML
    private TextField prixFld;
    @FXML
    private TextField descriptionFld;
    @FXML
    private TextField progFld;
    @FXML
    private TextField villeFld;
    @FXML
    private TextField durationFld;
    @FXML
    private TextField localisationFld;
    @FXML
    private ComboBox<String> catCombo;

    Excursioncategorie excursioncat = null;
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
        String prix = prixFld.getText();
        String desc = descriptionFld.getText();
        String prog = progFld.getText();
        String ville = villeFld.getText();
        String duration = durationFld.getText();
        String localisation = localisationFld.getText();

        if (lib.isEmpty() || prix.isEmpty() || desc.isEmpty() || prog.isEmpty() || ville.isEmpty() || duration.isEmpty() || localisation.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplissez tous les données SVP !");
            alert.showAndWait();
        } else {
            ExcursioncategorieService cs = new ExcursioncategorieService();
            excursioncat = cs.getCategorie(cat);
            Excursion p2 = new Excursion(excursioncat.getId(), lib, desc, prog, ville, prix, duration, localisation);
            ExcursionService ps = new ExcursionService();
            try {
                ps.ajouterr(p2);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setHeaderText(null);
                alert2.setContentText("Ajouté avec succés !");
                alert2.showAndWait();

            } catch (SQLException ex) {
                Logger.getLogger(ExcursionAddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void populateCategories() {
        ExcursioncategorieService ps = new ExcursioncategorieService();
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
