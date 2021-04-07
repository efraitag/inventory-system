
package efraitag.inventorysystem.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Eden
 *
 * This class loads the Modify Part Window
 * FUTURE ENHANCEMENT create a child of FXMLWindow that has the modified
 * start method used by ModifyPart and ModifyProduct
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
     * Overloads FXMLWindow.start to allow for the passing of an int value
     * to the controller
     * @param path the filepath to the fxml document
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
