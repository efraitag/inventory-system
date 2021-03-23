/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.stage.WindowEvent;

/**
 *
 * @author Eden
 */
public class Home extends Application{
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        
        HomeController homeController = new HomeController();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        //loader.setController(homeController);
        Parent root = loader.load();
        
        Scene rootScene = new Scene(root);
        
        stage.setTitle("Inventory Management System");
        stage.setScene(rootScene);
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event){
                Platform.exit();
            }
        });
        
        stage.show();
    }
    
}