
package efraitag.inventorysystem.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eden
 */

/**
 * This class opens the Modify Product window.
 * 
 * FUTURE ENHANCEMENT make the modified start function
 * common to modifyproduct and modifypart by use of a superclass
 */
public class ModifyProduct extends FXMLWindow{
    
    private final String PATH = "ModifyProduct.fxml";
    private final String TITLE = "Modify Product";
    private int id;
    
    /**
     * This starts the modify product window
     * 
     * @param id if of product to modify
     * @throws Exception if fxml file not found
     */
    public ModifyProduct(int id) throws Exception{
        this.id = id;
        start(PATH, TITLE, id);
    }
    
    /**
     * This function starts the modify product window
     * 
     * @param path path to the fxml file
     * @param title title of the window
     * @param id id of the product being modified
     * @throws Exception if the fxml file cannot be found
     */
    public void start(String path, String title, int id) throws Exception{
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlloader.load();
        
        //initialize textfield values after loading window fxml
        ModifyProductController controller = fxmlloader.<ModifyProductController>getController();
        controller.setId(id);
        
        Scene rootScene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(rootScene);
        stage.show();
    }
    
}
