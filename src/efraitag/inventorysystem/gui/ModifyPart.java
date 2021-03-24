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
    private int id;
    
    public ModifyPart(int id) throws Exception{
        this.id = id;
        start(PATH, TITLE, id);
    }
    
    /**
     * Overloads FXMLWindow.start
     * @param path the fielpath to the fxml document
     * @param title the window title
     * @param id the id of the Part to grab initializing data from
     * @throws Exception 
     */
    public void start(String path, String title, int id) throws Exception{
        
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlloader.load();
        
        //initialize textfield values after loading window fxml
        ModifyPartController controller = fxmlloader.<ModifyPartController>getController();
        controller.setId(id);
        
        Scene rootScene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(rootScene);
        stage.show();
    }
}
