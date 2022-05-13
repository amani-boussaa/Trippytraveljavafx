/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Maisonshotes;
import Entities.TypeMaison;
import Services.MaisonshotesService;
import Services.TypeMaisonService;
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


public class MaisonsAddFXMLController implements Initializable {
    @FXML
    private TextField capaciteFld;
    @FXML
    private TextField nbrChambresFld;
    @FXML
    private TextField typeMaison_idFld;
    @FXML
    private TextField libelleFld;
    @FXML
    private TextField LocalisationFld;
    @FXML
    private TextField proprietaireFld;
    @FXML
    private TextField prixFld;
     @FXML
    private ComboBox<String> typeCombo;
        TypeMaison typemaison = null;
    @FXML
    private Button btnClose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       populateCategories();  
    }
    
    @FXML
    private void insert(MouseEvent event) {
        String capacite = capaciteFld.getText();
        String type = typeCombo.getSelectionModel().getSelectedItem().toString();
        String nbrChambres = nbrChambresFld.getText();
        String typeMaison_id = typeMaison_idFld.getText();
        String libelle = libelleFld.getText();
        String Localisation = LocalisationFld.getText();
        String proprietaire = proprietaireFld.getText();
        String prix = prixFld.getText();
   
          if (capacite.isEmpty() || nbrChambres.isEmpty() || typeMaison_id.isEmpty() || libelle.isEmpty() || Localisation.isEmpty() || proprietaire.isEmpty() || prix.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplissez tous les données SVP !");
            alert.showAndWait();
        } else {
               TypeMaisonService cs = new TypeMaisonService();
            typemaison = cs.getCategorie(type);
            System.out.println(typemaison);
            Maisonshotes p2 = new Maisonshotes(typemaison.getId(), capacite, nbrChambres, typeMaison_id, libelle, Localisation, proprietaire, prix);
            MaisonshotesService ps = new MaisonshotesService();
             try {
                ps.ajouterr(p2);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setHeaderText(null);
                alert2.setContentText("Ajouté avec succés !");
                alert2.showAndWait();

            } catch (SQLException ex) {
                Logger.getLogger(MaisonsAddFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
          
}
    private void populateCategories() {
        TypeMaisonService ps = new TypeMaisonService();
        ObservableList<String> TypemaisonList = ps.getTypemaisonListtLibelle();
        typeCombo.setItems(TypemaisonList);
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
