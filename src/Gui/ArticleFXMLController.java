/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entities.Chartexcursion;
import Entities.Article;
import Entities.Category;
import Services.ArticleService;
import Services.ArticlecategoryService;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
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

/**
 * jfreechart library*
 */
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.fx.ChartViewer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;

/**
 * FXML Controller class
 *
 * @author amani
 */
public class ArticleFXMLController implements Initializable {

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
    private TableView<Article> excursionTable;
    @FXML
    private TableColumn<Article, String> idCol;
    @FXML
    private TableColumn<Article, String> libCol;

    @FXML
    private TableColumn<Article, String> prixCol;
    @FXML
    private TableColumn<Article, String> editCol;
    @FXML
    private Button btnArticlecat;

    Article excursion = null;
    Category excursioncat = null;

    ObservableList<Article> ExcursionList = FXCollections.observableArrayList();
    @FXML
    private TextField keywordTextField;
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
                Stage stageend = (Stage) btnBlog.getScene().getWindow();
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
        } else if (event.getSource() == btnArticlecat) {
            try {
                Stage stageend = (Stage) btnArticlecat.getScene().getWindow();
                // do what you have to do
                stageend.close();
                Parent parent;
                parent = FXMLLoader.load(getClass().getResource("/Gui/ArticleCategoryFXML.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Article catégories");
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
            parent = FXMLLoader.load(getClass().getResource("/Gui/ArticleAddFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ajouter article");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void refreshTable() {
        ExcursionList.clear();
        ArticleService ps = new ArticleService();
        ObservableList<Article> ExcursionList = ps.getExcursionList();
        excursionTable.setItems(ExcursionList);
    }

    public void showAll() {
        ArticleService ps = new ArticleService();
        ObservableList<Article> ExcursionList = ps.getExcursionList();
        idCol.setCellValueFactory(new PropertyValueFactory<>("views"));
        libCol.setCellValueFactory(new PropertyValueFactory<>("libelle"));
        prixCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        //excursionTable.setItems(ExcursionList);
        //add cell of button edit 
        Callback<TableColumn<Article, String>, TableCell<Article, String>> cellFoctory = (TableColumn<Article, String> param) -> {
            // make cell containing buttons
            final TableCell<Article, String> cell = new TableCell<Article, String>() {
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
                            loader.setLocation(getClass().getResource("/Gui/ArticleUpdateFXML.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            ArticleUpdateFXMLController updateExcursionController = loader.getController();
                            updateExcursionController.setTextField(excursion.getId(), excursion.getLibelle(),
                                    excursion.getExcursioncategorie_id(),
                                    excursion.getDescription());
                                    
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
        FilteredList<Article> filteredData = new FilteredList<>(ExcursionList, b -> true);
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
               
                return false;//no match found
            });
        });
        SortedList<Article> sortedData = new SortedList<>(filteredData);
        //bind sorted result with Table view
        sortedData.comparatorProperty().bind(excursionTable.comparatorProperty());
        //Apply filtered and sorted data to the table view
        excursionTable.setItems(sortedData);

    }

    @FXML
    private void chart(MouseEvent event) throws SQLException {
        ArticleService ps = new ArticleService();
        ObservableList<Chartexcursion> chartList = ps.chartcategorie();

        Stage stage = new Stage();
        DefaultPieDataset data = new DefaultPieDataset();
        /*data.setValue("Category 1", 43.2);
        data.setValue("Category 2", 27.9);
        data.setValue("Category 3", 79.5);*/
        for (Chartexcursion tab : chartList) {
            ArticlecategoryService cs = new ArticlecategoryService();
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
        PiePlot plot = (PiePlot) chart.getPlot();
         // random color for chart
        for (Chartexcursion tab : chartList) {
            ArticlecategoryService cs = new ArticlecategoryService();
            excursioncat = cs.findById(tab.getExcursioncategorie_id());
            // Java 'Color' class takes 3 floats, from 0 to 1.
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            plot.setSectionPaint(excursioncat.getLibelle(), new Color(r, g, b));
        }
        //end random color for chart
        plot.setSimpleLabels(true);

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
// create and display a scene...
        ChartViewer viewer = new ChartViewer(chart);
        stage.setScene(new Scene(viewer));
        stage.setTitle("JFreeChart: Excursion catégorie");
        stage.setWidth(700);
        stage.setHeight(390);
        stage.show();
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
