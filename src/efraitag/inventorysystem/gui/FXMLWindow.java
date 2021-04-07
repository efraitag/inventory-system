
package efraitag.inventorysystem.gui;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


/**
 * @author Eden
 */

/**
 * This class acts as a superclass to all of the windows that can be
 * opened from the main window. It has a simple start method that just
 * opens and loads an FXML file.
 * 
 * FUTURE ENHANCEMENT add more functions that are common to most of the windows
 * that implement this class
 */
public abstract class FXMLWindow {
    
    /**
     * 
     * @param path The path to the fxml file
     * @param title The title of the window
     * @throws Exception If FXML file is not found
     * 
     * This method loads an fxml file and adds it to a new stage
     */
    public void start(String path, String title) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(path));
        
        Scene rootScene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(rootScene);
        stage.show();
    }
    
}
