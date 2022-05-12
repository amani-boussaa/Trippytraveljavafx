/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trippytraveljava;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
 

/*

/**
 *
 * @author amani
 */
public class pdf  extends Application{

@Override
    public void start(Stage primaryStage) throws Exception {
    
    Document doc = new Document();
    try {
    
//generate a PDF at the specified location  
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\amani\\Desktop\\Motivation.pdf"));       

            System.out.println("PDF created.");
//opens the PDF  
            doc.open();
          
//adds paragraph to the PDF file  
            doc.add(new Paragraph("If you're offered a seat on a rocket ship, don't ask what seat! Just get on."));
//close the PDF file  
            doc.close();
//closes the writer  
            writer.close();
           /* Scene scene = new Scene(writer, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();*/
            primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

           StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        HostServices hs =  getHostServices();
        hs.showDocument("C:\\Users\\amani\\Desktop\\Motivation.pdf");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
     }
    public static void main(String[] args) {
        launch(args);
     
    }

   
}
