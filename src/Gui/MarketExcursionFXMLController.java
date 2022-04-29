/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import trippytraveljava.Main;
import trippytraveljava.MyListener;
import Entities.Excursion;
import Entities.Excursionrating;
import Services.ExcursionRatingService;
import Services.ExcursionService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class MarketExcursionFXMLController implements Initializable {
    
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label fruitNameLable;
    @FXML
    private Label fruitPriceLabel;
    @FXML
    private ImageView fruitImg;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
    
    Excursionrating excursionrating = null;
    /**
     * Initializes the controller class.
     */
    private List<Excursion> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private TextField id_selected_excursion;
    @FXML
    private Rating ratingdefault;
    
    private List<Excursion> getData() {
        List<Excursion> fruits = new ArrayList<>();
        Excursion fruit;
        ExcursionService prodService = new ExcursionService();
        try {
            fruits.addAll(prodService.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(MarketExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruits;
        
    }
    
    private void setChosenFruit(Excursion fruit) {
        id_selected_excursion.setText(String.valueOf(fruit.getId()));
        fruitNameLable.setText(fruit.getLibelle());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrix());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n"
                + "    -fx-background-radius: 30;");
        ExcursionRatingService ratingservice = new ExcursionRatingService();
        excursionrating = ratingservice.findrat(fruit.getId());
        System.out.println("ll");
        if(excursionrating!=null){
            if (excursionrating.getRating() != null) {
            ratingdefault.setRating(excursionrating.getRating());
        }
        }
       /* if (excursionrating.getRating() != null) {
            ratingdefault.setRating(excursionrating.getRating());            
        }*/
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fruits.addAll(getData());
        if (fruits.size() > 0) {
            setChosenFruit(fruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Excursion fruit) {
                    setChosenFruit(fruit);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < fruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/Gui/itemexcursion.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                
                ItemExcursionController itemController = fxmlLoader.getController();
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
    private void showRating(MouseEvent event) {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/ExcursionRatingFXML.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExcursionRatingFXMLController ratingExcursionController = loader.getController();
        ratingExcursionController.setTextField(Integer.valueOf(id_selected_excursion.getText()), Double.valueOf(ratingdefault.getRating()));
        Parent parent = loader.getRoot();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Rating excursion");
        stage.show();
    }
    
    void setTextField(double rating) {
        ratingdefault.setRating(rating);
    }
    
}
