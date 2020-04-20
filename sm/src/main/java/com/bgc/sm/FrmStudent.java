/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.sm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.effect.ImageInput;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author subhasish
 */
public class FrmStudent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Label rollno=new Label("Roll No");  
        Label name = new Label("Name"); 
        Label semester = new Label("Semester");
        Label email = new Label("Email Address");
        Label dob = new Label("Date of Birth");
        
        TextField txtRoll=new TextField();  
        TextField txtNam=new TextField(); 
        TextField txtSem=new TextField();  
        TextField txtEm=new TextField(); 
        TextField txtDb=new TextField();  
        
        Button btn = new Button();
        btn.setText("Submit");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override//callback function
            public void handle(ActionEvent event) {
                DataAccess da=new DataAccess();
                DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Student st;
                try {
                    
                    st = new Student(Integer.parseInt(txtRoll.getText()), txtNam.getText(),txtSem.getText(), txtEm.getText(), 
                                    sdf.parse(txtDb.getText()));
                    da.insertStudent(st);

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        GridPane root = new GridPane();  
        root.addRow(0, rollno, txtRoll);  
        root.addRow(1, name, txtNam);  
        root.addRow(2, semester, txtSem); 
        root.addRow(3, email, txtEm); 
        root.addRow(4, dob, txtDb); 
        root.addRow(5, new Label("           "),btn);
        
        root.setHgap(10);
        root.setVgap(10);
        
        Image image = new Image("http://www.iqacbgctub.com/documents/v/c/69.jpg");
        ImageInput imgIn=new ImageInput();
        imgIn.setSource(image);
        
        imgIn.setX(500);
        imgIn.setY(50);
        
        Rectangle rect = new Rectangle();
        rect.setEffect(imgIn);
        
        BorderPane bPane = new BorderPane();  
        bPane.setTop(new Label("                         "));  
        bPane.setLeft(new Label("                        ")); 
        
        bPane.getChildren().add(rect);
       
        //bPane.setRight(rect);  
        bPane.setBottom(new Label("                      "));          
        bPane.setCenter(root);
        
        Scene scene = new Scene(bPane, 800, 250);
        
        primaryStage.setTitle("New Student Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
