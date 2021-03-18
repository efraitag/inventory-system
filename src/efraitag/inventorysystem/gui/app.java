/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Eden
 */
public class app extends Application{
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        
        Scene rootScene = new Scene(root);
        
        stage.setTitle("Inventory Management System");
        stage.setScene(rootScene);
        stage.show();
    }
    
}
