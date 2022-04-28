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
import Services.ExcursionService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Initializes the controller class.
     */
    private List<Excursion> fruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;

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
       /* fruit = new Excursion();
        fruit.setLibelle("Kiwi");
        fruit.setPrix("2.99");
        fruit.setImgSrc("/img/kiwi.png");
        fruit.setColor("6A7324");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Coconut");
        fruit.setPrix("3.99");
        fruit.setImgSrc("/img/coconut.png");
        fruit.setColor("A7745B");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Peach");
        fruit.setPrix("1.50");
        fruit.setImgSrc("/img/peach.png");
        fruit.setColor("F16C31");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Grapes");
        fruit.setPrix("0.99");
        fruit.setImgSrc("/img/grapes.png");
        fruit.setColor("291D36");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Watermelon");
        fruit.setPrix("4.99");
        fruit.setImgSrc("/img/watermelon.png");
        fruit.setColor("22371D");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Orange");
        fruit.setPrix("2.99");
        fruit.setImgSrc("/img/orange.png");
        fruit.setColor("FB5D03");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("StrawBerry");
        fruit.setPrix("0.99");
        fruit.setImgSrc("/img/strawberry.png");
        fruit.setColor("80080C");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Mango");
        fruit.setPrix("0.99");
        fruit.setImgSrc("/img/mango.png");
        fruit.setColor("FFB605");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Cherry");
        fruit.setPrix("0.99");
        fruit.setImgSrc("/img/cherry.png");
        fruit.setColor("5F060E");
        fruits.add(fruit);

        fruit = new Excursion();
        fruit.setLibelle("Banana");
        fruit.setPrix("1.99");
        fruit.setImgSrc("/img/banana.png");
        fruit.setColor("E7C00F");
        fruits.add(fruit);

        return fruits;*/
    }

    private void setChosenFruit(Excursion fruit) {
        fruitNameLable.setText(fruit.getLibelle());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrix());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
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
                itemController.setData(fruits.get(i),myListener);

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
    
}
