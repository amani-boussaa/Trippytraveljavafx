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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class MaisonsFXMLController implements Initializable {
     @FXML
    private Button btnExcursion;
    @FXML
    private Button btnHotel;
    @FXML
    private Button btnMaison;
      @FXML
    private Button btnTypeMaison;
    @FXML
    private Button btnAttraction;
    @FXML
    private Button btnBlog;
    @FXML
    private Button btnReclamation;
    @FXML
    private Button btnDeconnexion;
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
    
    @FXML
    private TableColumn<Maisonshotes, String> prixCol;
    @FXML
    private TableColumn<Maisonshotes, String> editCol;

    Maisonshotes maisonshotes = null;

    ObservableList<Maisonshotes> MaisonsList = FXCollections.observableArrayList();

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
   showAll();
    }
    @FXML
    public void handleclicks(ActionEvent event) {
        if (event.getSource() == btnExcursion) {
            lblstatus.setText("Excursions");
        } else if (event.getSource() == btnHotel) {
            lblstatus.setText("Hotels");
        } else if (event.getSource() == btnMaison) {
            lblstatus.setText("Maisons d'hote");
        }else if (event.getSource() == btnTypeMaison) {
            lblstatus.setText("type Maison");
            
        } else if (event.getSource() == btnAttraction) {
            lblstatus.setText("Attraction");
        } else if (event.getSource() == btnBlog) {
            lblstatus.setText("Blog");
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
    }

   
  
}
