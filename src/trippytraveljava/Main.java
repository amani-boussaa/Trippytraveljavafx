 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trippytraveljava;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author amani
 */
public class Main extends Application{

    Stage stage;
    Parent parent;
    public static final String CURRENCY = "$";
    @Override
    public void start(Stage primaryStage) {
        this.stage= primaryStage;
        try {
            parent = FXMLLoader.load(getClass().getResource("/Gui/ExcursionFXML.fxml"));
            Scene scene= new Scene(parent);
            stage.setScene(scene);
            stage.setTitle("Trippy travel");
            stage.show();
            
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
