/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Excursioncategorie;

import Services.ExcursioncategorieService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;

import java.io.IOException;
import java.net.URL;

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
 * @author amani
 */
public class ExcursionCategorieFXMLController implements Initializable {

    @FXML
    private Button btnExcursion;
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
    @FXML
    private TableView<Excursioncategorie> excursioncatTable;
    @FXML
    private TableColumn<Excursioncategorie, String> idCol;
    @FXML
    private TableColumn<Excursioncategorie, String> libCol;

    @FXML
    private TableColumn<Excursioncategorie, String> editCol;
    @FXML
    private Pane pnlStatus;
    @FXML
    private Label lblstatus;
    @FXML
    private TextField keywordTextField;
    @FXML
    private FontAwesomeIconView btnClose;
    Excursioncategorie categorie = null;
    Excursioncategorie excursioncat = null;
    ObservableList<Excursioncategorie> ExcursioncatList = FXCollections.observableArrayList();
    @FXML
    private Button btnExcursioncat1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showAll();
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
            parent = FXMLLoader.load(getClass().getResource("/Gui/ExcursionCategorieAddFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter catégorie excursion");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refreshTable() {
        ExcursioncatList.clear();
        ExcursioncategorieService ps = new ExcursioncategorieService();
        ObservableList<Excursioncategorie> ExcursioncatList = ps.getExcursioncategorieList();
        excursioncatTable.setItems(ExcursioncatList);
    }

    public void showAll() {
        ExcursioncategorieService ps = new ExcursioncategorieService();
        ObservableList<Excursioncategorie> ExcursioncatList = ps.getExcursioncategorieList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        libCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));

        //add cell of button edit 
        Callback<TableColumn<Excursioncategorie, String>, TableCell<Excursioncategorie, String>> cellFoctory = (TableColumn<Excursioncategorie, String> param) -> {
            // make cell containing buttons
            final TableCell<Excursioncategorie, String> cell = new TableCell<Excursioncategorie, String>() {
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
                            categorie = excursioncatTable.getSelectionModel().getSelectedItem();
                            ps.supprimer(categorie.getId());
                            refreshTable();
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                            categorie = excursioncatTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/Gui/ExcursionCategorieUpdateFXML.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            ExcursionCategorieUpdateFXMLController updatecatExcursionController = loader.getController();
                            updatecatExcursionController.setTextField(categorie.getId(), categorie.getLibelle());
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
        //excursioncTable.setItems(ExcursionList);
        //recherche
        FilteredList<Excursioncategorie> filteredData = new FilteredList<>(ExcursioncatList, b -> true);
        keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Excursioncategorie -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (Excursioncategorie.getLibelle().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }

                return false;//no match found
            });
        });
        SortedList<Excursioncategorie> sortedData = new SortedList<>(filteredData);
        //bind sorted result with Table view
        sortedData.comparatorProperty().bind(excursioncatTable.comparatorProperty());
        //Apply filtered and sorted data to the table view
        excursioncatTable.setItems(sortedData);

    }

    @FXML
    private void showMarket(MouseEvent event) {
        try {
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("/Gui/MarketExcursionFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Market excursion");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
