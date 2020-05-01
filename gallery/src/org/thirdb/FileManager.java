/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thirdb;

import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.concurrent.Task;
/**
 *
 * @author subhasish
 */
public class FileManager extends Task{
    static ArrayList<String> filesLoc=new ArrayList<String>();
   
    @Override
    protected Object call() throws Exception {
         
        Path rootPath = Paths.get("/home/subhasish/Pictures/");
        String fileToFind = File.separator + "banner_update.png";

        try {
            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
              String fileString = file.toAbsolutePath().toString();
              System.out.println("pathString = " + fileString);
              filesLoc.add(fileString);
              if(fileString.endsWith(fileToFind)){
                System.out.println("file found at path: " + file.toAbsolutePath());
                return FileVisitResult.TERMINATE;
              }
              return FileVisitResult.CONTINUE;
            }
          });
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
