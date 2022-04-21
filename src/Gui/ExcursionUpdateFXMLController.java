/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursion;
import Services.ExcursionService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void update(MouseEvent event) {
        String lib = libFld.getText();
        String cattxt = catFld.getText();
        int cat = 1;
        if (cattxt.isEmpty()) {
            cat = 1;
        } else {
            cat = Integer.parseInt(catFld.getText());
        }
        String prix = prixFld.getText();
        String desc = descriptionFld.getText();
        String prog = progFld.getText();
        String ville = villeFld.getText();
        String duration = durationFld.getText();
        String localisation = localisationFld.getText();

        Excursion p2 = new Excursion(studentId, cat, lib, desc, prog, ville, prix, duration, localisation);
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
    }

}
