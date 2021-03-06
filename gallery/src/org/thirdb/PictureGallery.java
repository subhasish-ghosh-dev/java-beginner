/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thirdb;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author subhasish
 */
public class PictureGallery extends Application {
    int idx=0;
    String fileLoc="";
    ArrayList<String> filesLoc=new ArrayList<String>();
    Task task = new FileManager(); 
    
    @Override
    public void start(Stage primaryStage) {
        filesLoc.add("C:\\Users\\my\\Pictures\\beautiful_natural_scenery_04_hd_pictures_166229.jpg");
        filesLoc.add("C:\\Users\\my\\Pictures\\mountain.jpg");
        filesLoc.add("C:\\Users\\my\\Pictures\\photo-1554266183-2696fdafe3ff.jpg");
        Label lblFile=new Label(fileLoc);   
        BorderPane root = new BorderPane();        
        startTask();
        
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        
        filesLoc = FileManager.filesLoc;    
        Button nextBtn = new Button();
        nextBtn.setText("Next");
        nextBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                                
                //System.out.println(filesLoc.size());
                //System.out.print("idx: "+idx);
                //System.out.println(" "+(idx<filesLoc.size()));
                if(idx<filesLoc.size()-1){                    
                    idx=idx+1;
                }
                fileLoc=filesLoc.get(idx);
                //System.out.println(fileLoc);
                lblFile.setText(fileLoc);
                Image img = new Image("file:///"+fileLoc,width,height-300,false,false);//("file:///home/subhasish/Pictures/banner_update.png",600,400,false,false);
                ImageView imgIcon = new ImageView(img);
                
                //Rectangle rect=new Rectangle();                
                //rect.setEffect(imgIcon); 
                HBox rect=new HBox();
                rect.getChildren().add(imgIcon);
                root.setTop(rect);
            }
        });


        Button prevBtn = new Button();
        prevBtn.setText("Previous");
        prevBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {            
                //System.out.println(filesLoc.size()); 
                if(idx>0){
                    idx=idx-1;
                }
                fileLoc=filesLoc.get(idx);
                //System.out.println(fileLoc);
                lblFile.setText(fileLoc);
                Image img = new Image("file:///"+fileLoc,width,height-300,false,false);//("file:///home/subhasish/Pictures/banner_update.png",600,400,false,false);
                ImageView imgIcon = new ImageView(img);
                
                //Rectangle rect=new Rectangle();                
                //rect.setEffect(imgIcon); 
                HBox rect=new HBox();
                rect.getChildren().add(imgIcon);
                root.setTop(rect);
            }
        });
        fileLoc=filesLoc.get(0);
        //System.out.println(fileLoc);
        lblFile.setText(fileLoc);
        Image img = new Image("file:///"+"C:\\Users\\my\\Pictures\\beautiful_natural_scenery_04_hd_pictures_166229.jpg",width,height-300,false,false);//("file:///home/subhasish/Pictures/banner_update.png",600,400,false,false);
        ImageView imgIcon = new ImageView(img);
                
                //Rectangle rect=new Rectangle();                
                //rect.setEffect(imgIcon); 
                HBox rect=new HBox();
                rect.getChildren().add(imgIcon);
                root.setTop(rect);
   
        root.setLeft(new Label(""));
        root.setRight(new Label(""));
        root.setCenter(new Label(""));

        HBox hbox=new HBox();
        hbox.getChildren().addAll(prevBtn,lblFile,nextBtn );
        hbox.setPadding(new Insets(5,5,10,200));
        hbox.setSpacing(20);
        root.setBottom(hbox);
        
        BorderPane.setAlignment(hbox,Pos.CENTER_LEFT);
        Scene scene = new Scene(root, width-200,height-200);

        primaryStage.setTitle("Picture Gallery");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        Application.launch(args);
    }
    
    
    private void startTask() {    
        Thread backgroundThread = new Thread(task);
        backgroundThread.setName("FileThread");
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }
}
