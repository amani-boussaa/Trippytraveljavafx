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
import java.util.ResourceBundle;
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
public class ExcursionCategorieUpdateFXMLController implements Initializable {
 int studentId;
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

    void setTextField(int id, String libelle) {
        studentId = id;
        libFld.setText(libelle);
    }

    @FXML
    private void update(MouseEvent event) {
        String lib = libFld.getText();
       
      
        Excursioncategorie p2 = new Excursioncategorie(studentId,lib);
        ExcursioncategorieService ps = new ExcursioncategorieService();
        ps.modifer(p2);
        Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
        alert2.setHeaderText(null);
        alert2.setContentText("Modifié avec succés !");
        alert2.showAndWait();
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
