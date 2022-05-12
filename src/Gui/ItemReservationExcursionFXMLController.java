/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursion;
import Entities.Excursionreservation;
import Services.ExcursionService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import trippytraveljava.Main;
import trippytraveljava.MyListener;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ItemReservationExcursionFXMLController implements Initializable {

    @FXML
    private Label nameLabel;
    @FXML
    private Label priceLable;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void click(MouseEvent event) {
    myListener.onClickReservationListener(excursion,reservation);
    }

    private Excursion excursion;
    private Excursionreservation reservation;
    private MyListener myListener;

    public void setData(Excursionreservation reservation, MyListener myListener) {
        ExcursionService es = new ExcursionService();
        this.excursion = es.findById(reservation.getExcursion_id());
        this.reservation = reservation;
        this.myListener = myListener;
        nameLabel.setText(excursion.getLibelle());
        priceLable.setText(Main.CURRENCY + reservation.getPrix());
        Image image = new Image(getClass().getResourceAsStream(excursion.getImgSrc()));
        img.setImage(image);
    }
    
}
