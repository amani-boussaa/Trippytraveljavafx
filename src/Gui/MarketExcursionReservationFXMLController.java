/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursion;
import Entities.Excursionreservation;
import Services.ExcursionRatingService;
import Services.ExcursionService;
import Services.ExcursionreservationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import trippytraveljava.Main;
import trippytraveljava.MyListener;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class MarketExcursionReservationFXMLController implements Initializable {
    private List<Excursionreservation> fruits = new ArrayList<>();
 private MyListener myListener;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private ImageView fruitImg;
    @FXML
    private TextField id_selected_excursion;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    private Image image;
    @FXML
    private TextField id_selected_reservation;
    @FXML
    private Label excursionMENU;
    @FXML
    private Label mes_reservationLBL;
    
    private List<Excursionreservation> getData() {
        List<Excursionreservation> fruits = new ArrayList<>();
        Excursionreservation fruit;
        ExcursionreservationService prodService = new ExcursionreservationService();
        try {
            fruits.addAll(prodService.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(MarketExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruits;

    }
     private void setChosenFruit(Excursion fruit,Excursionreservation excursionreservation) {
        id_selected_reservation.setText(String.valueOf(excursionreservation.getId()));
        id_selected_excursion.setText(String.valueOf(fruit.getId()));
        fruitNameLable.setText(fruit.getLibelle());
        fruitPriceLabel.setText(Main.CURRENCY + excursionreservation.getPrix());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #222831" + ";\n"
                + "    -fx-background-radius: 30;");
       
       
    }
      private void setChosenExcursion(Excursion fruit) {
          System.out.println("ok");
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         fruits.addAll(getData());
         
         if (fruits.size() > 0) {
              ExcursionService es = new ExcursionService();
              ExcursionreservationService res = new ExcursionreservationService();
            setChosenFruit(es.findById(fruits.get(0).getExcursion_id()),res.findById(fruits.get(0).getId()));
            myListener = new MyListener() {
                @Override
                public void onClickReservationListener(Excursion fruit,Excursionreservation excursionreservation) {
                    setChosenFruit(fruit,excursionreservation);
                }

                  @Override
                  public void onClickListener(Excursion excursion) {
                      setChosenExcursion(excursion);
                  }
            };
        }
         int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Gui/ItemReservationExcursionFXML.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemReservationExcursionFXMLController itemController = fxmlLoader.getController();
                itemController.setData(fruits.get(i), myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    

    @FXML
    private void reserver(ActionEvent event) {
    }


    @FXML
    private void mesreservation(MouseEvent event) {
        try {
            if (event.getSource() == mes_reservationLBL) {
            Stage stageend = (Stage) mes_reservationLBL.getScene().getWindow();
                // do what you have to do
                stageend.close();
            }
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("/Gui/MarketExcursionReservationFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Mes réservation excursion");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void show_payment_form(MouseEvent event) {
         FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/ExcursionStripeFXML.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExcursionStripeFXMLController stripeExcursionController = loader.getController();
        stripeExcursionController.setTextField(Integer.valueOf(id_selected_excursion.getText()),Integer.valueOf(id_selected_reservation.getText()));
        Parent parent = loader.getRoot();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Paiement stripe excursion");
        stage.show();
    }

    @FXML
    private void addreclamation(MouseEvent event) {
         try {
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("/Gui/Reclamation.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Réclamation");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        String email=null;
        String roles=null;
        UserSession.getInstace(email, roles).cleanUserSession();
        System.out.println(UserSession.getInstace(email, roles));
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
        
        UserSession us = new UserSession();
        us.cleanUserSession();
        
    }

    @FXML
    private void excursionlistemenu(MouseEvent event) {
        try {
            if (event.getSource() == excursionMENU) {
            Stage stageend = (Stage) excursionMENU.getScene().getWindow();
                // do what you have to do
                stageend.close();
            }
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("/Gui/MarketExcursionFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Excursions");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
