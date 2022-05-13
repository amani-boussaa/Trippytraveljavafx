/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Maisonshotes;
import Services.MaisonshotesService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import org.controlsfx.control.Rating;

public class MaisonsFXMLController implements Initializable {
    @FXML
    private Button btnSMS;
     @FXML
    private Button btnExcursion;
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
    @FXML
    private TextField recherche;
    @FXML
    private Label lblstatus;
    @FXML
    private Pane pnlStatus;
    @FXML
    private FontAwesomeIconView btnClose;
    @FXML
    private TableView<Maisonshotes> MaisonTable;
    @FXML
    private TableColumn<Maisonshotes, String> idCol;
    @FXML
    private TableColumn<Maisonshotes, String> capaciteCol;
     @FXML
    private TableColumn<Maisonshotes, String> nbrChambresCol;
      @FXML
    private TableColumn<Maisonshotes, String> typeMaison_idCol;
       @FXML
    private TableColumn<Maisonshotes, String> libelleCol;
      @FXML
    private TableColumn<Maisonshotes, String> LocalisationCol;
       @FXML
    private TableColumn<Maisonshotes, String> proprietaireCol;
    private Rating ratingdefault;
    
    @FXML
    private TableColumn<Maisonshotes, String> prixCol;
    @FXML
    private TableColumn<Maisonshotes, String> editCol;

    Maisonshotes maisonshotes = null;

    ObservableList<Maisonshotes> MaisonsList = FXCollections.observableArrayList();
    @FXML
    private Button btnExcursioncat1;
    @FXML
    private Button bntHotel;
    @FXML
    private Button btnSMS1;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   showAll();
    }
    @FXML
      public void handleclicks(ActionEvent event) {
        if (event.getSource() == btnExcursion) {
            lblstatus.setText("Excursions");
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
                stage.setTitle("Excursion catégorie");
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
            lblstatus.setText("Réclamations");
        } else if (event.getSource() == btnDeconnexion) {
            lblstatus.setText("Déconnexion");
        }
    }

     @FXML
    private void handleClose(MouseEvent event) {
        if (event.getSource() == btnClose) {
             // get a handle to the stage
            Stage stage = (Stage) btnClose.getScene().getWindow();
            // do what you have to do
            stage.close();
        }
    }
    @FXML
  private void getAddview(MouseEvent event) {
       try {
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("/Gui/MaisonsAddFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter maison");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
     

    }
   @FXML
    private void jouer(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/GUI/jeuFXML.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
  
    @FXML
    private void SMS(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/Gui/SMS.fxml"));
                 Button node = (Button) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));
}
    @FXML
    private void ladate(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/GUI/Date.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
    
   @FXML
    private void refreshTable() {
        MaisonsList.clear();
        MaisonshotesService ps = new MaisonshotesService();
        ObservableList<Maisonshotes> MaisonsList = ps.getMaisonsList();
        MaisonTable.setItems(MaisonsList);
    }
    public void showAll() {
        MaisonshotesService ps = new MaisonshotesService();
       
        ObservableList<Maisonshotes> MaisonsList = ps.getMaisonsList();
        System.out.println(MaisonsList);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        capaciteCol.setCellValueFactory(new PropertyValueFactory<>("capacite"));
        nbrChambresCol.setCellValueFactory(new PropertyValueFactory<>("nbrChambres"));
        typeMaison_idCol.setCellValueFactory(new PropertyValueFactory<>("typeMaison_id"));
        libelleCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        LocalisationCol.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
        proprietaireCol.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        //excursionTable.setItems(ExcursionList);
        
    //add cell of button edit 
        Callback<TableColumn<Maisonshotes, String>, TableCell<Maisonshotes, String>> cellFoctory = (TableColumn<Maisonshotes, String> param) -> {
            // make cell containing buttons
            final TableCell<Maisonshotes, String> cell = new TableCell<Maisonshotes, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                        deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                            maisonshotes = MaisonTable.getSelectionModel().getSelectedItem();
                            ps.supprimer(maisonshotes.getId());
                            refreshTable();
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                            maisonshotes = MaisonTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/Gui/MaisonsAddFXML.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            MaisonsUpdateFXMLController updateMaisonsController = loader.getController();
                            updateMaisonsController.setTextField(maisonshotes.getId(), maisonshotes.getCapacite(),
                                    maisonshotes.getNbrChambres(),
                                    maisonshotes.getTypeMaison_id(), maisonshotes.getLibelle(), maisonshotes.getLocalisation(), maisonshotes.getProprietaire(),
                                    maisonshotes.getPrix());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
        editCol.setCellFactory(cellFoctory);
        MaisonTable.setItems(MaisonsList);
          FilteredList<Maisonshotes> filteredData = new FilteredList<>(MaisonsList, b -> true);
        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("hhhh");
            filteredData.setPredicate(maisonshotes -> {
                
                String searchKeyword = newValue.toLowerCase();
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                if (maisonshotes.getLibelle().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                
                return false;//no match found
            });
        });
        SortedList<Maisonshotes> sortedData = new SortedList<>(filteredData);
        //bind sorted result with Table view
        sortedData.comparatorProperty().bind(MaisonTable.comparatorProperty());
        //Apply filtered 
    MaisonTable.setItems(MaisonsList);
    }
    private void showMarket(ActionEvent event) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/MarketMaisonFXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MaisonsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
 @FXML
    private void showRating(ActionEvent event) {

         Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/GUI/MaisonRatingFXML.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MaisonsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }

    void setTextField(double rating) {
        ratingdefault.setRating(rating);
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
