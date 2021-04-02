
package efraitag.inventorysystem.gui;

/**
 * @author Eden
 * This class opens the AddProduct Window
 * FUTURE ENHANCEMENT make the main window disappear while this is active
 */
public class AddProduct extends FXMLWindow{
    
    private final String PATH = "AddProduct.fxml";
    private final String TITLE = "Add Product";
    
    public AddProduct() throws Exception{
        super.start(PATH, TITLE);
    }
    
}
