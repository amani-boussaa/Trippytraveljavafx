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


class MaisonsUpdateFXMLController implements Initializable {
 @FXML
    private TextField capaciteFld;
    @FXML
    private TextField nbrChambresFld;
  
    @FXML
    private TextField libelleFld;
    @FXML
    private TextField LocalisationFld;
    @FXML
    private TextField proprietaireFld;
    @FXML
    private TextField prixFld;
     int studentId;
    @FXML
    private ComboBox<String> typeCombo;
    TypeMaison typemaison = null;
    @FXML
    private Button btnClose;
    private Integer type;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
  populateCategories();
    }
       @FXML
    private void update(MouseEvent event) {
          String capacite = capaciteFld.getText();
        String type = typeCombo.getSelectionModel().getSelectedItem().toString();
        String nbrChambres = nbrChambresFld.getText();
       
        String libelle = libelleFld.getText();
        String Localisation = LocalisationFld.getText();
        String proprietaire = proprietaireFld.getText();
        String prix = prixFld.getText();
         TypeMaisonService cs = new TypeMaisonService();
        typemaison = cs.getCategorie(type);
        // Maisonshotes p2 = new Maisonshotes(typemaison.getId(), capacite, nbrChambres,  libelle, Localisation, proprietaire, prix);
            MaisonshotesService ps = new MaisonshotesService();
      //      ps.modifer(p2);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setHeaderText(null);
        alert2.setContentText("Modifié avec succés !");
        alert2.showAndWait();

    }
     void setTextField(int id, String capacite, String nbrChambres, int typeMaison_id, String libelle, String localisation, String proprietaire, String prix) {

        studentId = id;
        capaciteFld.setText(capacite);
        nbrChambresFld.setText(nbrChambres);
      
        libelleFld.setText(libelle);
        LocalisationFld.setText(localisation);
        prixFld.setText(prix);
       
        /**set selected categori**/
        TypeMaisonService cs = new TypeMaisonService();
        typemaison = cs.findById(type);
        typeCombo.setValue(typemaison.getLibelle());
    }
       private void populateCategories() {
        TypeMaisonService ps = new TypeMaisonService();
        ObservableList<String> TypeMaisonList = ps.getTypeMaisonListlibelle();
        typeCombo.setItems(TypeMaisonList);
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
