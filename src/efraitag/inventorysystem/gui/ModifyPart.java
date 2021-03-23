/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eden
 */
public class ModifyPart extends FXMLWindow{
    
    private final String PATH = "ModifyPart.fxml";
    private final String TITLE = "Modify Part";
    private int index;
    
    public ModifyPart(int index) throws Exception{
        this.index = index;
        start(PATH, TITLE, index);
    }
    
    public void start(String path, String title, int index) throws Exception{
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlloader.load();
        
        ModifyPartController controller = fxmlloader.<ModifyPartController>getController();
        controller.setIndex(index);
        
        Scene rootScene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(rootScene);
        stage.show();
    }
}
