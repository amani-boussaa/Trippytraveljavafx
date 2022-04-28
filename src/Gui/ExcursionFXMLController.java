/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Chartexcursion;
import Entities.Excursion;
import Entities.Excursioncategorie;
import Services.ExcursionService;
import Services.ExcursioncategorieService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
 * jfreechart library*
 */
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.JFreeChart;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ExcursionFXMLController implements Initializable {

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
    private Label lblstatus;
    @FXML
    private Pane pnlStatus;
    @FXML
    private FontAwesomeIconView btnClose;
    @FXML
    private TableView<Excursion> excursionTable;
    @FXML
    private TableColumn<Excursion, String> idCol;
    @FXML
    private TableColumn<Excursion, String> libCol;

    @FXML
    private TableColumn<Excursion, String> prixCol;
    @FXML
    private TableColumn<Excursion, String> editCol;

    Excursion excursion = null;
    Excursioncategorie excursioncat = null;

    ObservableList<Excursion> ExcursionList = FXCollections.observableArrayList();
    @FXML
    private TextField keywordTextField;

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
            lblstatus.setText("Excursions");
        } else if (event.getSource() == bntHotel) {
            lblstatus.setText("Hotels");
        } else if (event.getSource() == btnMaison) {
            lblstatus.setText("Maisons d'hote");
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
            parent = FXMLLoader.load(getClass().getResource("/Gui/ExcursionAddFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter excursion");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refreshTable() {
        ExcursionList.clear();
        ExcursionService ps = new ExcursionService();
        ObservableList<Excursion> ExcursionList = ps.getExcursionList();
        excursionTable.setItems(ExcursionList);
    }

    public void showAll() {
        ExcursionService ps = new ExcursionService();
        ObservableList<Excursion> ExcursionList = ps.getExcursionList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        libCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("prix"));
        //excursionTable.setItems(ExcursionList);
        //add cell of button edit 
        Callback<TableColumn<Excursion, String>, TableCell<Excursion, String>> cellFoctory = (TableColumn<Excursion, String> param) -> {
            // make cell containing buttons
            final TableCell<Excursion, String> cell = new TableCell<Excursion, String>() {
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
                            excursion = excursionTable.getSelectionModel().getSelectedItem();
                            ps.supprimer(excursion.getId());
                            refreshTable();
                        });
                        editIcon.setOnMouseClicked((MouseEvent event) -> {

                            excursion = excursionTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/Gui/ExcursionUpdateFXML.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            ExcursionUpdateFXMLController updateExcursionController = loader.getController();
                            updateExcursionController.setTextField(excursion.getId(), excursion.getLibelle(),
                                    excursion.getExcursioncategorie_id(),
                                    excursion.getPrix(), excursion.getDescription(), excursion.getProgramme(), excursion.getVille(),
                                    excursion.getDuration(), excursion.getLocalisation());
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
        //excursionTable.setItems(ExcursionList);
        //recherche
        FilteredList<Excursion> filteredData = new FilteredList<>(ExcursionList, b -> true);
        keywordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(Excursion -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKeyword = newValue.toLowerCase();
                if (Excursion.getLibelle().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                if (Excursion.getDescription().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                if (Excursion.getPrix().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                if (Excursion.getProgramme().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                if (Excursion.getLocalisation().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                if (Excursion.getDuration().toLowerCase().indexOf(searchKeyword) > -1) {
                    return true;//means we found a match in libelle exursion
                }
                return false;//no match found
            });
        });
        SortedList<Excursion> sortedData = new SortedList<>(filteredData);
        //bind sorted result with Table view
        sortedData.comparatorProperty().bind(excursionTable.comparatorProperty());
        //Apply filtered and sorted data to the table view
        excursionTable.setItems(sortedData);

    }

    @FXML
    private void chart(MouseEvent event) throws SQLException {
        ExcursionService ps = new ExcursionService();
        ObservableList<Chartexcursion> chartList = ps.chartcategorie();

        
        Stage stage = new Stage();
        DefaultPieDataset data = new DefaultPieDataset();
        /*data.setValue("Category 1", 43.2);
        data.setValue("Category 2", 27.9);
        data.setValue("Category 3", 79.5);*/
        for (Chartexcursion tab : chartList) {
             ExcursioncategorieService cs = new ExcursioncategorieService();
            excursioncat = cs.findById(tab.getExcursioncategorie_id());
            data.setValue(excursioncat.getLibelle(), tab.getCount());
        }
// create a chart...
        JFreeChart chart = ChartFactory.createPieChart(
                "Pie Chart-Excursion catégories",
                data,
                true, // legend?
                true, // tooltips?
                false // URLs?
        );
// create and display a scene...
        ChartViewer viewer = new ChartViewer(chart);
        stage.setScene(new Scene(viewer));
        stage.setTitle("JFreeChart: Excursion catégorie");
        stage.setWidth(700);
        stage.setHeight(390);
        stage.show();
    }
}
