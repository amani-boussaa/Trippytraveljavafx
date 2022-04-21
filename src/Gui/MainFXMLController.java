/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class MainFXMLController implements Initializable {

    @FXML
    private Button btnExcursion;
    @FXML
    private Button bntHotel;
    @FXML
    private Button btnMaison;
    @FXML
    private Button btnAttraction;
    @FXML
    private Button btnBlog;
    @FXML
    private Button btnReclamation;
    @FXML
    private Button btnDeconnexion;
    @FXML
    private Label lblstatus;
    @FXML
    private Pane pnlStatus;
    @FXML
    private FontAwesomeIconView btnClose;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handleclicks(ActionEvent event) {
        if (event.getSource() == btnExcursion) {
            lblstatus.setText("Excursions");
        } else if (event.getSource() == bntHotel) {
            lblstatus.setText("Hotels");
        } else if (event.getSource() == btnMaison) {
            lblstatus.setText("Maisons d'hote");
        } else if (event.getSource() == btnAttraction) {
            lblstatus.setText("Attraction");
        } else if (event.getSource() == btnBlog) {
            lblstatus.setText("Blog");
        } else if (event.getSource() == btnReclamation) {
            lblstatus.setText("Réclamations");
        } else if (event.getSource() == btnDeconnexion) {
            lblstatus.setText("Déconnexion");
        }
    }

    @FXML
    private void handleClose(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }
    
    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
        
        UserSession us = new UserSession();
        us.cleanUserSession();
        
    }
}