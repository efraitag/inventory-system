/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


/**
 *
 * @author Eden
 */
public abstract class FXMLWindow {
    
    public void start(String path, String title) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path));
        
        Scene rootScene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(rootScene);
        stage.show();
    }
    
}
