 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trippytraveljava;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author amani
 */
public class Main extends Application{

    Stage stage;
    Parent parent;
    public static final String CURRENCY = "DT";
    @Override
    public void start(Stage primaryStage) {
        this.stage= primaryStage;
        try {
            parent = FXMLLoader.load(getClass().getResource("/Gui/signup.fxml"));
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
