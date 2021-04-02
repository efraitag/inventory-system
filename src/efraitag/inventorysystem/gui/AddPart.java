
package efraitag.inventorysystem.gui;

/**
 * @author Eden
 * This class creates and opens the AddPart window
 * FUTURE ENHANCEMENT make the main frame disappear when this opens.
 */
public class AddPart extends FXMLWindow{
    
    private final String PATH = "AddPart.fxml";
    private final String TITLE = "Add Part";
    
    public AddPart() throws Exception{
        super.start(PATH, TITLE);
    }
    
}
