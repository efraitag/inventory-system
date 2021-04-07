
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.WindowEvent;

/**
 *
 * @author Eden
 */

/**
 * This class launches the main window.
 * 
 * FUTURE ENHANCEMENT add a menu for options and to inject data from file
 */
public class Home extends Application{
    
    /**
     * 
     * @param args launch arguments
     * launches the program
     * 
     * JAVADOC located in InventorySystem/dist/javadoc/index.html
     */
    public static void main(String[] args){
        launch(args);
    }
    
    /**
     * 
     * @param stage Stage to load the main program onto
     * @throws Exception if the fxml file is not found
     * 
     * RUNTIME ERROR the entire program would not exit when the main
     * window closed, so I set the onCloseRequest to Platform.exit()
     */
    @Override
    public void start(Stage stage) throws Exception{
        
        HomeController homeController = new HomeController();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        //loader.setController(homeController);
        Parent root = loader.load();
        
        Scene rootScene = new Scene(root);
        
        //inject test data on press of F1
        rootScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if(event.getCode() == KeyCode.F1){
                    Inventory.addPart(new InHouse(1, "Wheel", 95.99, 4, 4, 8, 678));
                    Inventory.addPart(new Outsourced(2, "Brake", 59.99, 10, 10, 25, "BrakeCo."));
                }
                else if(event.getCode() == KeyCode.ESCAPE){
                    Platform.exit();
                }
            }
        });
        
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