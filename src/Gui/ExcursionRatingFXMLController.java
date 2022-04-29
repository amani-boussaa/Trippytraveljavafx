/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursion;
import Entities.Excursionrating;
import Services.ExcursionRatingService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.controlsfx.control.Rating;
import trippytraveljava.MyListener;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ExcursionRatingFXMLController implements Initializable {

    @FXML
    private Rating excursionRating;
    int excursion_Id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        ExcursionRatingService ratingservice = new ExcursionRatingService();
        Excursionrating t = new Excursionrating(excursion_Id, 1, excursionRating.getRating());

        try {
            ratingservice.ajouterr(t);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Gui/MarketExcursionFXML.fxml"));
            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            MarketExcursionFXMLController marketExcursionController = loader.getController();
            marketExcursionController.setTextField(excursionRating.getRating());
            //close this window and open another to refresh rating
            Stage stage1 = (Stage) excursionRating.getScene().getWindow();
            // do what you have to do
            stage1.close();
            //open another stage
            Parent parent = loader.getRoot();
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Rating excursion");
            stage.show();
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Succés");

            // Header Text: null
            alert.setHeaderText(null);
            alert.setContentText("Votre avis est enregistré avec succés. Merci!");

            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(ExcursionRatingFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void setTextField(int id, Double rating2) {

        excursion_Id = id;
        excursionRating.setRating(rating2);

    }

}
