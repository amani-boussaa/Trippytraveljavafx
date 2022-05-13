package Gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import trippytraveljava.Main;
import trippytraveljava.MyListener;
import Entities.Excursion;
import Entities.Maisonrating;
import Entities.Maisonshotes;
import Services.MaisonratingService;
import Services.MaisonshotesService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.HostServices;
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
public class MarketMaisonFXMLController implements Initializable  {

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

    Maisonrating maisonrating = null;
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
    @FXML
    private TextField keywordTextField;
HostServices hostServices ;
    private List<Maisonshotes> getData() {
        List<Maisonshotes> fruits = new ArrayList<>();
        Maisonshotes fruit;
        MaisonshotesService prodService = new MaisonshotesService();
        try {
            fruits.addAll(prodService.afficher());
        } catch (SQLException ex) {
            Logger.getLogger(MarketMaisonFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fruits;

    }

    private void setChosenFruit(Maisonshotes fruit) {
        id_selected_excursion.setText(String.valueOf(fruit.getId()));
        fruitNameLable.setText(fruit.getLibelle());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrix());
        image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n"
                + "    -fx-background-radius: 30;");
        MaisonratingService ratingservice = new MaisonratingService();
        maisonrating = ratingservice.findrat(fruit.getId());
        if (maisonrating != null) {
            if (maisonrating.getRating() != null) {
                ratingdefault.setRating(maisonrating.getRating());
            }
        }
       
    }

    
    @FXML
    private void showRating(MouseEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Gui/MaisonRatingFXML.fxml"));
        try {
            loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        MaisonRatingFXMLController ratingMaisonController = loader.getController();
        ratingMaisonController.setTextField(Integer.valueOf(id_selected_excursion.getText()), Double.valueOf(ratingdefault.getRating()));
        Parent parent = loader.getRoot();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Rating maison");
        stage.show();
    }

    void setTextField(double rating) {
        ratingdefault.setRating(rating);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

    

 

}