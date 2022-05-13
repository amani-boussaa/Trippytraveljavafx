/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.HotelService;
import Utils.MailerService;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import trippytraveljava2.Entities.Hotel;

/**
 * FXML Controller class
 *
 * @author ihebd
 */
public class HotelInterController implements Initializable {

    @FXML
    private TextField libelle_H;
    @FXML
    private TextField localisation_H;
    @FXML
    private TextField etoile_H;
    @FXML
    private Button ajouter_H;
    @FXML
    private TextField chambre_H;
    @FXML
    private Button modifier_H;
    @FXML
    private Button supprimer_H;
    @FXML
    private TableView<Hotel> ListH;
    @FXML
    private TableColumn<Hotel, String> lh;
    @FXML
    private TableColumn<Hotel, String> loh;
    @FXML
    private TableColumn<Hotel, Integer> eh;
    @FXML
    private TableColumn<Hotel, Integer> ch;
    @FXML
    private TableColumn<Hotel, String> dh;
    /*@FXML
    private TableColumn<Hotel, ?> nF2;
    @FXML
    private TableColumn<Hotel, ?> nF3;*/
    @FXML
    private TextField description_H;
    @FXML
    private Label er_lib;
    @FXML
    private Label er_loc;
    @FXML
    private Label er_et;
    @FXML
    private Label er_ch;
  
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lblstatus;
    @FXML
    private TextField recherche;
        ObservableList<Hotel> dataList;
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
        showF();
    }    

    @FXML
    private void ajouter(ActionEvent event) {
            HotelService serv = new HotelService();
       if (libelle_H.getText().isEmpty())
         {
             
             serv.music();
             Notifications notificationBuilder= Notifications.create()
                  .title("erreur")
                  .text("invalid Libelle")
                  .graphic(null)
                  .position(Pos.CENTER)
                  .onAction(new EventHandler <ActionEvent>()
                  {@Override
                  public void handle(ActionEvent event)
                  {System.out.println("clicked");
                  }
                  }
                  );
                 notificationBuilder.darkStyle();

                  notificationBuilder.showError();
                  
                        return;
                    }
       if (localisation_H.getText().isEmpty())
         {
                       Notifications notificationBuilder= Notifications.create()
                  .title("erreur")
                  .text("invalid Localisation")
                  .graphic(null)
                  .position(Pos.CENTER)
                  .onAction(new EventHandler <ActionEvent>()
                  {@Override
                  public void handle(ActionEvent event)
                  {System.out.println("clicked");
                  }
                  }
                  );
                 notificationBuilder.darkStyle();

                  notificationBuilder.showError();
                  
                        return;
                    }
       if ((etoile_H.getText().isEmpty())  )
         {
                       Notifications notificationBuilder= Notifications.create()
                  .title("erreur")
                  .text("invalid star number")
                  .graphic(null)
                  .position(Pos.CENTER)
                  .onAction(new EventHandler <ActionEvent>()
                  {@Override
                  public void handle(ActionEvent event)
                  {System.out.println("clicked");
                  }
                  }
                  );
                 notificationBuilder.darkStyle();

                  notificationBuilder.showError();
                  
                        return;
                    }
       if (chambre_H.getText().isEmpty())
         {
                       Notifications notificationBuilder= Notifications.create()
                  .title("erreur")
                  .text("invalid chambre number")
                  .graphic(null)
                  .position(Pos.CENTER)
                  .onAction(new EventHandler <ActionEvent>()
                  {@Override
                  public void handle(ActionEvent event)
                  {System.out.println("clicked");
                  }
                  }
                  );
                 notificationBuilder.darkStyle();

                  notificationBuilder.showError();
                  
                        return;
                    }
       if (description_H.getText().isEmpty())
         {
                       Notifications notificationBuilder= Notifications.create()
                  .title("erreur")
                  .text("invalid Description")
                  .graphic(null)
                  .position(Pos.CENTER)
                  .onAction(new EventHandler <ActionEvent>()
                  {@Override
                  public void handle(ActionEvent event)
                  {System.out.println("clicked");
                  }
                  }
                  );
                 notificationBuilder.darkStyle();

                  notificationBuilder.showError();
                  
                        return;
                    }
       if (!(parseInt(etoile_H.getText())<6 && parseInt(etoile_H.getText())>0  ))
           
       {
           serv.music();
            Notifications notificationBuilder= Notifications.create()
                  .title("erreur")
                  .text("nombre etoile invalide")
                  .graphic(null)
                  .position(Pos.CENTER)
                  .onAction(new EventHandler <ActionEvent>()
                  {@Override
                  public void handle(ActionEvent event)
                  {System.out.println("clicked");
                  }
                  }
                  );
                 notificationBuilder.darkStyle();

                  notificationBuilder.showError();
                  
                        return;
          
       }
       
      
       
      
        Hotel f=new Hotel(libelle_H.getText(),localisation_H.getText(),parseInt(etoile_H.getText()),parseInt(chambre_H.getText()),description_H.getText());
        serv.ajouterForm(f);
        serv.musica();
         MailerService m=new MailerService();
    m.replyMail("iheb.dridi1@esprit.tn", "User", "ajout d'hotel", "Bonjour , un Hotel a été ajouté avec succès");
        
        showF();
    }

    @FXML
    private void onsave(MouseEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
         Hotel f=new Hotel(libelle_H.getText(),localisation_H.getText(),parseInt(etoile_H.getText()),parseInt(chambre_H.getText()),description_H.getText());
        System.out.println(f);
         HotelService serv = new HotelService();
         serv.updateHotel(f,ListH.getSelectionModel().getSelectedItem().getLibelle());
          showF();
    }

    @FXML
    private void supprimer(ActionEvent event) {
         HotelService s= new HotelService();
        System.out.println(ListH.getSelectionModel().getSelectedItem().getLibelle());
        s.deleteHotel(ListH.getSelectionModel().getSelectedItem().getLibelle());
        showF();
    }
    
    public void showF(){
         HotelService serv = new HotelService();
        ObservableList<Hotel> s = serv.getAllForm();
        
       
        
        lh.setCellValueFactory(new PropertyValueFactory<Hotel, String>("libelle"));
        loh.setCellValueFactory(new PropertyValueFactory<Hotel, String>("localisation"));
        eh.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbetoile"));
        ch.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbchdispo"));
        dh.setCellValueFactory(new PropertyValueFactory<Hotel, String>("description_hotel"));
        
        
        
        ListH.setItems(s);
      
    }

    @FXML
    private void cherche(ActionEvent event) {
        
        lh.setCellValueFactory(new PropertyValueFactory<Hotel, String>("libelle"));
        loh.setCellValueFactory(new PropertyValueFactory<Hotel, String>("localisation"));
        eh.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbetoile"));
        ch.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("nbchdispo"));
        dh.setCellValueFactory(new PropertyValueFactory<Hotel, String>("description_hotel"));
        
         try{
              HotelService serv = new HotelService();
          dataList =serv.getAllForm();
         
          ListH.setItems(dataList);
          FilteredList<Hotel> filtredData = new FilteredList<>(dataList, b -> true);
          recherche.textProperty().addListener((observable, olValue, newValue)->{
             filtredData.setPredicate(Hotel-> {
                 if(newValue == null|| newValue.isEmpty()){
                     
                     return true;
                 }
                 String lowerCaseFilter= newValue.toLowerCase();
                 if(Hotel.getLibelle().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }else if(Hotel.getLocalisation().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }else if(String.valueOf(Hotel.getNbetoile()).toLowerCase().indexOf(lowerCaseFilter)!=-1){
                     return true;
                 }
                 else if(String.valueOf(Hotel.getNbchdispo()).indexOf(lowerCaseFilter)!=-1)
                     return true;
                 else if(String.valueOf(Hotel.getDescription_hotel()).indexOf(lowerCaseFilter)!=-1)
                     return true;
                     else
                     return false;
                 });
             });
         SortedList<Hotel> sortedData = new SortedList<>(filtredData);
         sortedData.comparatorProperty().bind(ListH.comparatorProperty());
         ListH.setItems(sortedData);

         }catch(Exception e){
             System.out.println(e.getMessage());
             
         }

    }

    @FXML
    private void stat(ActionEvent event) {
        
         try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Stats.fxml"));
        //AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("Stats.fxml"));
        /*
         * if "fx:controller" is not set in fxml
         * fxmlLoader.setController(NewWindowController);
         */
        Scene scene = new Scene(fxmlLoader.load(), 630, 400);
        Stage stage = new Stage();
        stage.setTitle("Statistique");
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
    private void handleclicks(ActionEvent event) {
    }

    @FXML
    private void deconnexion(MouseEvent event) {
    }

    

    
}
