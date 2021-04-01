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
public class ModifyProduct extends FXMLWindow{
    
    private final String PATH = "ModifyProduct.fxml";
    private final String TITLE = "Modify Product";
    private int id;
    
    public ModifyProduct(int id) throws Exception{
        this.id = id;
        start(PATH, TITLE, id);
    }
    
    public void start(String path, String title, int id) throws Exception{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlloader.load();
        
        //initialize textfield values after loading window fxml
        ModifyProductController controller = fxmlloader.<ModifyProductController>getController();
        controller.setId(id);
        
        System.out.println("it gets this far at least");
        Scene rootScene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(rootScene);
        stage.show();
    }
    
}
