/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.CategorieAttraction;
import Services.CategorieAttractionService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author cheri
 */
public class CategorieAttractionInterfaceController implements Initializable {

    @FXML
    private TextField libelleC;
    @FXML
    private CheckBox contrainteC;
    @FXML
    private Button ajoutC;
    @FXML
    private Button modC;
    @FXML
    private Button supC;
    @FXML
    private TableView<CategorieAttraction> ListC;
    @FXML
    private TableColumn<CategorieAttraction, String> lC;
    @FXML
    private TableColumn<CategorieAttraction, Boolean> cC;
    @FXML
    private Label erreurlibC;
    @FXML
    private Label erreurcontrainte;
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lblstatus;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showAll();
    }    

     @FXML
    private void inscrire(ActionEvent event) {
        if (libelleC.getText().isEmpty())
         {
                        erreurlibC.setText("Libelle non valide !");
                        erreurlibC.setVisible(true);
                  
                        return;
                    }


    CategorieAttraction parti =new CategorieAttraction();
    
    parti.setLibelle(libelleC.getText());

    
    
    
    CategorieAttractionService serv = new CategorieAttractionService();
    
    
    serv.ajouterCategorieAttraction(parti);
    showAll();
    
    }
    
    @FXML
    private void onsave(MouseEvent event) {
    }
    
    @FXML
    private void modifier(ActionEvent event) {

    }
    
    @FXML
    private void supprimer(ActionEvent event) {
    CategorieAttractionService s= new CategorieAttractionService();
    System.out.println(ListC.getSelectionModel().getSelectedItem().getLibelle());
    s.deleteCategorieAttraction(ListC.getSelectionModel().getSelectedItem().getLibelle());
    showAll();
    }
        
    public void showAll(){
         CategorieAttractionService serv = new CategorieAttractionService();
        ObservableList<CategorieAttraction> s = serv.getAllForm();
        
       
        
        lC.setCellValueFactory(new PropertyValueFactory<CategorieAttraction, String>("libelle"));
        cC.setCellValueFactory(new PropertyValueFactory<CategorieAttraction, Boolean>("contrainteAge"));
        
        
        ListC.setItems(s);
      
    }


    
    }
    
    
     
    

