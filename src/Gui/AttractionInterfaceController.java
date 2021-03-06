/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Attraction;
import Services.AttractionService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Button;
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
public class AttractionInterfaceController implements Initializable {

    @FXML
    private TextField libelleA;
    @FXML
    private TextField localisationA;
    @FXML
    private TextField horraireA;
    @FXML
    private Button ajoutA;
    @FXML
    private TextField prixA;
    @FXML
    private Button modA;
    @FXML
    private Button supA;
    @FXML
    private TableView<Attraction> ListA;
    @FXML
    private TableColumn<Attraction, String> lA;
    @FXML
    private TableColumn<Attraction, String> localA;
    @FXML
    private TableColumn<Attraction, String> hA;
    @FXML
    private TableColumn<Attraction, Integer> pA;
    @FXML
    private Label erreurlib;
    @FXML
    private Label erreurlocal;
    @FXML
    private Label erreurho;
    @FXML
    private Label erreurp;
    @FXML
    private TextField rechercherC;
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lblstatus;
    ObservableList<Attraction> list;
    @FXML
    private Button modifier_H1;
    @FXML
    private Button btnExcursion;
    @FXML
    private Button btnExcursioncat1;
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
            AttractionService serv = new AttractionService();
        if (libelleA.getText().isEmpty())
         {
                        erreurlib.setText("Libelle non valide !");
                        erreurlib.setVisible(true);
                        serv.musicF();
                        return;
                    }
    if (localisationA.getText().isEmpty())
         {
                        erreurlocal.setText("Localisation non valide !");
                        erreurlocal.setVisible(true);
                        serv.musicF();
                        return;
                    }
    if (horraireA.getText().isEmpty())
         {
                        erreurho.setText("Horraire non valide !");
                        erreurho.setVisible(true);
                        serv.musicF();
                        return;
                    }
    if (prixA.getText().isEmpty())
         {
                        erreurp.setText("Prix non valide !");
                        erreurp.setVisible(true);
                        serv.musicF();
                        return;
                    }
    Attraction parti =new Attraction();
    
    parti.setLibelle(libelleA.getText());
    parti.setLocalisation(localisationA.getText());
    
    parti.setHorraire(horraireA.getText());
    parti.setPrix(parseInt(prixA.getText()));
    

    serv.ajouterAttraction(parti);
    serv.musicS();
    showAll();
    
    }
    
    @FXML
    private void onsave(MouseEvent event) {
    
    }
    
    @FXML
    private void modifier(ActionEvent event) {
    Attraction f=new Attraction(libelleA.getText(),localisationA.getText(), horraireA.getText(),parseInt(prixA.getText()));
    System.out.println(f);
    AttractionService serv = new AttractionService();
    serv.updateAttraction(f,ListA.getSelectionModel().getSelectedItem().getLibelle());
    showAll();
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
    AttractionService s= new AttractionService();
    System.out.println(ListA.getSelectionModel().getSelectedItem().getLibelle());
    s.deleteAttraction(ListA.getSelectionModel().getSelectedItem().getLibelle());
    showAll();
    }
        
    public void showAll(){
         AttractionService serv = new AttractionService();
        ObservableList<Attraction> s = serv.getAllForm();
        
       
        
        lA.setCellValueFactory(new PropertyValueFactory<Attraction, String>("libelle"));
        localA.setCellValueFactory(new PropertyValueFactory<Attraction, String>("localisation"));
        hA.setCellValueFactory(new PropertyValueFactory<Attraction, String>("horraire"));
        pA.setCellValueFactory(new PropertyValueFactory<Attraction, Integer>("prix"));
        
        
        ListA.setItems(s);
      
    }
    
    @FXML
    private void cherche(ActionEvent event) {
        
         
        lA.setCellValueFactory(new PropertyValueFactory<Attraction, String>("libelle"));
        localA.setCellValueFactory(new PropertyValueFactory<Attraction, String>("localisation"));
        hA.setCellValueFactory(new PropertyValueFactory<Attraction, String>("horraire"));
        pA.setCellValueFactory(new PropertyValueFactory<Attraction, Integer>("prix"));
          
         try{
              AttractionService serv = new AttractionService();
          list =serv.getAllForm();
         
          ListA.setItems(list);
          FilteredList<Attraction> filtredData = new FilteredList<>(list, b -> true);
          rechercherC.textProperty().addListener((observable, olValue, newValue)->{
             filtredData.setPredicate(Attraction-> {
                 if(newValue == null|| newValue.isEmpty()){
                     
                     return true;
                 }
                 String lowerCaseFilter= newValue.toLowerCase();
                 if(Attraction.getLibelle().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }else if(Attraction.getLocalisation().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }else if(String.valueOf(Attraction.getHorraire()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }
                 else if(String.valueOf(Attraction.getPrix()).indexOf(lowerCaseFilter)!=-1)
                     return true;
                     else
                     return false;
                 });
             });
         SortedList<Attraction> sortedData = new SortedList<>(filtredData);
         sortedData.comparatorProperty().bind(ListA.comparatorProperty());
         ListA.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }

    }
    

        @FXML
    private void stat(ActionEvent event) {
        
         try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("StatsYASSIN.fxml"));
        //AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("Stats.fxml"));
        /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Statistiques");
        stage.setScene(scene);
        stage.show();
    } catch (IOException e) {
        Logger logger = Logger.getLogger(getClass().getName());
        logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }

    }

    @FXML
    private void showMarket(MouseEvent event) {
    }

    @FXML
     public void handleclicks(ActionEvent event) {
        if (event.getSource() == btnExcursion) {
           try {
                Stage stageend = (Stage) btnExcursion.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/ExcursionFXML.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Excursion");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == btnExcursioncat1) {
            try {
                Stage stageend = (Stage) btnExcursioncat1.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/ExcursionCategorieFXML.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Excursion cat??gorie");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == bntHotel) {

            try {
                Stage stageend = (Stage) bntHotel.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/HotelInter.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Hotel");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == btnMaison) {
            // lblstatus.setText("Maisons d'hote");
            try {
                Stage stageend = (Stage) btnMaison.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/MaisonsFXML.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Maison");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == btnAttraction) {
            try {
                Stage stageend = (Stage) btnAttraction.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/AttractionInterface.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Attraction");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == btnBlog) {
            try {
                Stage stageend = (Stage) btnAttraction.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/ArticleFXML.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Article");
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ExcursionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getSource() == btnReclamation) {
            lblstatus.setText("R??clamations");
        } else if (event.getSource() == btnDeconnexion) {
            lblstatus.setText("D??connexion");
        }
    }

    @FXML
    void deconnexion(MouseEvent event) throws IOException {
        String email = null;
        String roles = null;
        UserSession.getInstace(email, roles).cleanUserSession();
        System.out.println(UserSession.getInstace(email, roles));
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));

        UserSession us = new UserSession();
        us.cleanUserSession();

    }


    
    }
    
    
     
    

