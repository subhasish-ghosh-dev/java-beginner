/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bgc.sm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.*;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.effect.ImageInput;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 *
 * @author subhasish
 */
public class FrmStudent extends Application {
    VBox vbox=new VBox();
    HBox hbox1=new HBox();
    ComboBox comboId = new ComboBox();
    ArrayList<Integer> ids= new ArrayList<Integer>();
    TableView<StudentBean> tbl = new TableView<StudentBean>();
    BorderPane bPane = new BorderPane(); 
    MenuBar menuBar = new MenuBar();

    @Override
    public void start(Stage primaryStage) {
        Label rollno=new Label("Roll No");  
        Label name = new Label("Name"); 
        Label semester = new Label("Semester");
        Label email = new Label("Email Address");
        Label dob = new Label("Date of Birth");
        Label lblCombo = new Label("Search By Roll No");

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
        
        
        bPane.setLeft(new Label("                        "));
        
        Menu actions = new Menu("Manage");
        MenuItem insert = new MenuItem("Insert");
        MenuItem read = new MenuItem("Read");
        
        insert.setOnAction(new EventHandler<ActionEvent>() {            
            @Override//callback function
            public void handle(ActionEvent event) {
                Image image = new Image("http://www.iqacbgctub.com/documents/v/c/69.jpg");
                ImageInput imgIn=new ImageInput();
                imgIn.setSource(image);

                imgIn.setX(250);
                imgIn.setY(50);

                Rectangle rect = new Rectangle();
                rect.setEffect(imgIn);
                
                
                GridPane root = new GridPane();
                root.addRow(0, new Label(), rect);
                root.addRow(1, rollno, txtRoll);  
                root.addRow(2, name, txtNam);  
                root.addRow(3, semester, txtSem); 
                root.addRow(4, email, txtEm); 
                root.addRow(5, dob, txtDb); 
                root.addRow(6, new Label("           "),btn);

                root.setHgap(10);
                root.setVgap(10);

                

                bPane.setCenter(root);
               
               }
            });
       
        
        read.setOnAction(new EventHandler<ActionEvent>() {            
            @Override//callback function
            public void handle(ActionEvent event) {
                DataAccess da=new DataAccess();
                List<StudentBean> students1=da.getStudents();
                ObservableList<StudentBean> students = FXCollections.observableList(students1);
                
                tbl.setItems(students);
                for(StudentBean stb:students1){
                    ids.add(stb.getRollNo());
                }
                comboId.setItems(FXCollections.observableList(ids));
                TableColumn rollCol = new TableColumn("Roll No");
                rollCol.setCellValueFactory(new PropertyValueFactory("rollNo"));
                TableColumn nameCol = new TableColumn("Name");
                nameCol.setCellValueFactory(new PropertyValueFactory("name"));
                TableColumn semesterCol = new TableColumn("Semester");
                semesterCol.setCellValueFactory(new PropertyValueFactory("semester"));
                TableColumn emailCol = new TableColumn("Email");
                emailCol.setCellValueFactory(new PropertyValueFactory("email"));
                TableColumn dobCol = new TableColumn("Date Of Birth");
                dobCol.setCellValueFactory(new PropertyValueFactory("dob"));
                
                tbl.getColumns().setAll(rollCol, nameCol, semesterCol, emailCol, dobCol);
                tbl.setPrefWidth(450);
                tbl.setPrefHeight(300);           
                bPane.setCenter(vbox);
            }
        });       
        
        vbox.setPadding(new Insets(5,5,5,5));
        vbox.getChildren().addAll(lblCombo, comboId, tbl);
        
        
        actions.getItems().addAll(insert, read);
        menuBar.getMenus().add(actions);      
        
        
        bPane.setTop(menuBar);  
        //bPane.setRight(rect);  
        bPane.setBottom(new Label("                      "));          
        
        
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
