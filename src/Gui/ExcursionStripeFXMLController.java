/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursionreservation;
import Services.ControleInputsService;
import Services.ExcursionStripe;
import Services.ExcursionreservationService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ExcursionStripeFXMLController implements Initializable {

    int reservation_Id;
    int excursion_Id;
    boolean is_paid = false;
    @FXML
    private Button btnClose;
    @FXML
    private TextField cardFld;
    @FXML
    private TextField emailFld1;
    @FXML
    private TextField cvcFld;
    @FXML
    private TextField moisFld;
    @FXML
    private TextField anneeFld;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    void setTextField(int excursion,int reservation) {
        reservation_Id = reservation;   
        excursion_Id = excursion;

    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        ControleInputsService controlservice = new ControleInputsService();
        String cardnum = cardFld.getText();
        String email = emailFld1.getText();
        String cvc = cvcFld.getText();       
        String mois = moisFld.getText();
        String annee = anneeFld.getText();


        if (cardnum.isEmpty()   || email.isEmpty() || mois.isEmpty()|| annee.isEmpty() || cvc.isEmpty() ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Remplissez tous les données SVP !");
            alert.showAndWait();
        }else if(!(controlservice.isNumeric(cardnum)) || !(controlservice.isNumeric(mois)) || !(controlservice.isNumeric(annee)) || !(controlservice.isNumeric(cvc))){
            Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setHeaderText(null);
            alert3.setContentText("Les valeurs doivent etre numéric SVP !");
            alert3.showAndWait();
        }
        else {
            
            ExcursionStripe ps = new ExcursionStripe();
            is_paid = ps.payer(reservation_Id, cardnum, email, mois,annee, cvc);
            System.out.println("is_paid="+is_paid);
            if (is_paid == true) {
                ExcursionreservationService service = new ExcursionreservationService();
                Excursionreservation reservation = service.findById(reservation_Id);
                reservation.setStatus("succeeded");
                service.modifer(reservation);
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setContentText("Payé avec succés !");
                alert2.setHeaderText(null);
                alert2.showAndWait();
            } else {
                Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setContentText("Paiement échoué");
                alert2.setHeaderText(null);
                alert2.showAndWait();
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
