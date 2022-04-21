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

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ExcursionUpdateFXMLController implements Initializable {

    @FXML
    private TextField libFld;
    @FXML
    private TextField catFld;
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
    int studentId;
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
    private void update(MouseEvent event) {
        String lib = libFld.getText();
        /*String cattxt = catFld.getText();
        int cat = 1;
        if (cattxt.isEmpty()) {
            cat = 1;
        } else {
            cat = Integer.parseInt(catFld.getText());
        }*/
        String cat = catCombo.getSelectionModel().getSelectedItem().toString();
        String prix = prixFld.getText();
        String desc = descriptionFld.getText();
        String prog = progFld.getText();
        String ville = villeFld.getText();
        String duration = durationFld.getText();
        String localisation = localisationFld.getText();
        ExcursioncategorieService cs = new ExcursioncategorieService();
        excursioncat = cs.getCategorie(cat);
        Excursion p2 = new Excursion(studentId, excursioncat.getId(), lib, desc, prog, ville, prix, duration, localisation);
        ExcursionService ps = new ExcursionService();
        ps.modifer(p2);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setHeaderText(null);
        alert2.setContentText("Modifié avec succés !");
        alert2.showAndWait();
    }

    void setTextField(int id, String lib, int cat, String prix, String desc, String prog, String ville, String duration, String localisation) {

        studentId = id;
        libFld.setText(lib);
        catFld.setText(String.valueOf(cat));
        prixFld.setText(prix);
        descriptionFld.setText(desc);
        progFld.setText(prog);
        villeFld.setText(ville);
        durationFld.setText(duration);
        localisationFld.setText(localisation);
        /**set selected categori**/
        ExcursioncategorieService cs = new ExcursioncategorieService();
        excursioncat = cs.findById(cat);
        catCombo.setValue(excursioncat.getLibelle());
    }

        private void populateCategories() {
        ExcursioncategorieService ps = new ExcursioncategorieService();
        ObservableList<String> ExcursioncategorieList = ps.getExcursioncategorieListLibelle();
        catCombo.setItems(ExcursioncategorieList);
    }

    @FXML
    private void handleClose(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }

}
