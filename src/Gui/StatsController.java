/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Services.HotelService;
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
 * @author seifi
 */
public class StatsController implements Initializable {

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
         HotelService serv = new HotelService();
        Integer s1 = serv.Stats("Soussa","localisation");
        Integer s2 = serv.Stats("Tunis","localisation");
        Integer s3 = serv.Stats("Hammamet","localisation");
        Integer s4 = serv.Stats("Gabes","localisation");
       ;
      

     ObservableList<PieChart.Data> PieChartData
             =FXCollections.observableArrayList(
                     new PieChart.Data("Soussa",s1),
                     new PieChart.Data("Tunis",s2),
                     new PieChart.Data("Hammamet",s3),
                      new PieChart.Data("Gabes",s4)
                  

             );
     chartfor.setData(PieChartData);
     
    }
    
    
     
        
  
    
}
