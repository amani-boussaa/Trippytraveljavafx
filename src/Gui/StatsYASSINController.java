/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.AttractionService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 *
 * @author cheri
 */
public class StatsYASSINController implements Initializable {

    @FXML
    private PieChart chartfor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
 localisation();
 
      
    }   

  

    private void localisation() {
         AttractionService serv = new AttractionService();
        Integer s1 = serv.Stats("Sousse","localisation");
        Integer s2 = serv.Stats("Carthage","localisation");
        Integer s3 = serv.Stats("Monastir","localisation");
       // Integer s4 = serv.Stats("Djerba","localisation");
        Integer s5 = serv.Stats("Tunis","localisation");
       ;
      

     ObservableList<PieChart.Data> PieChartData
             =FXCollections.observableArrayList(
                     new PieChart.Data("Sousse",s1),
                     new PieChart.Data("Carthage",s2),
                     new PieChart.Data("Monastir",s3),
                     // new PieChart.Data("Djerba",s4),
                      new PieChart.Data("Tunis",s5)
                  

             );
     chartfor.setData(PieChartData);
     
    }
    
    
     
        
  
    
}
