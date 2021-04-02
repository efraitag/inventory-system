
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.Inventory;
import efraitag.inventorysystem.data.Part;
import efraitag.inventorysystem.data.Product;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;

/**
 * @author Eden
 * This class controls the main window of the application
 * FUTURE ENHANCEMENT handle Exceptions with more than just a system.out
 */
public class HomeController {
    
    @FXML private TableView<Part> partTable;
    @FXML private TableView<Product> productTable;
    @FXML private TextField partSearch;
    @FXML private TextField productSearch;
    
    private TableViewSelectionModel partTableSelectionModel;
    private TableViewSelectionModel productTableSelectionModel;
    private ObservableList partTableCols;
    private ObservableList productTableCols;
    private ObservableList observablePartList;
    
    public void HomeController() {
        observablePartList = Inventory.getAllParts();
    }
    
    /**
     * initializes the part and product tables
     */
    @FXML
    public void initialize(){
        partTableSelectionModel = partTable.getSelectionModel();
        productTableSelectionModel = productTable.getSelectionModel();
 
        partTable.setItems(Inventory.getAllParts());
        productTable.setItems(Inventory.getAllProducts());
    }
    
    /**
     * 
     * @param searchText
     * @return 
     */
    public static ObservableList<Part> partSearch(String searchText){
        ObservableList<Part> resultList = FXCollections.observableArrayList(new ArrayList<>());
        
        //if blank, reset to default
        if(searchText.equals("")){
            return Inventory.getAllParts();
        }
        
        //if contains a digit, try and parse
        else if(searchText.matches("\\d")){
            try{
                resultList.setAll(Inventory.lookupPart(Integer.parseInt(searchText)));
            }
            catch(Exception e){
                //is mixed, just search as name
                resultList = Inventory.lookupPart(searchText);
            }
        }
        
        //if just a name, search names
        else{
            resultList = Inventory.lookupPart(searchText);
        }
        
        //let the user know if no matches found
        if (resultList == null){
            new Alert(AlertType.INFORMATION, "No Matches Found.").showAndWait();
        }
        
        return resultList;
    }
    
    /**
     * 
     */
    public void doPartSearch(){
        String searchText = partSearch.getText();
        partTable.setItems(partSearch(searchText));       
    }
    
    /**
     * RUNTIME ERROR exceptions from AddPart constructor were not handled,
     *               so it was surrounded in a try catch statement
     */
    public void openAddPart(){
        try{
            FXMLWindow window = new AddPart();
        }
        catch(Exception e){}
    }
    
    /**
     * 
     */
    public void openModifyPart(){
        try{
            int id = partTable.getSelectionModel().getSelectedItems().get(0).getId();
            FXMLWindow window = new ModifyPart(id);
        } catch(Exception e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).showAndWait();
        }
    }
    
    /**
     * 
     */
    public void deletePart(){
        Part selectedPart = partTable.getSelectionModel().getSelectedItem();
        Inventory.deletePart(selectedPart);
    }
    
    /**
     * 
     * @param searchText
     * @return 
     */
    public static ObservableList<Product> productSearch(String searchText){
        ObservableList<Product> resultList = FXCollections.observableArrayList(new ArrayList<>());
        
        //if blank, reset to default
        if(searchText.equals("")){
            return Inventory.getAllProducts();
        }
        
        //if contains a digit, try and parse
        else if(searchText.matches("\\d")){
            try{
                resultList.setAll(Inventory.lookupProduct(Integer.parseInt(searchText)));
            }
            catch(Exception e){
                //is mixed,  just search as a name
                resultList = Inventory.lookupProduct(searchText);
            }
        }
        
        //if just a name, search names
        else{
            resultList = Inventory.lookupProduct(searchText);
        }
        
        if(resultList == null){
            new Alert(AlertType.INFORMATION, "No matches found.").showAndWait();
        }
        
        return resultList;
    }
    
    /**
     * 
     */
    public void doProductSearch(){
        String searchText = productSearch.getText();
        productTable.setItems(productSearch(searchText));
    }
    
    /**
     * 
     */
    public void openAddProduct(){
        try{
            FXMLWindow window = new AddProduct();
        } catch(Exception e){}
    }
    
    /**
     * 
     */
    public void openModifyProduct(){
        try{
            int id = productTable.getSelectionModel().getSelectedItems().get(0).getId();
            FXMLWindow window = new ModifyProduct(id);
        } catch(Exception e){}
    }
    
    /**
     * 
     */
    public void deleteProduct(){
        ObservableList<Integer> selectedProduct = productTableSelectionModel.getSelectedIndices();
        
        if(selectedProduct == null){
            //TODO Error pop-up
            return;
        }
        else{
            productTable.getItems().remove(selectedProduct.get(0));
        }
    }
    
    /**
     * 
     */
    public void exitApplication(){
        //TODO Save before exit
        System.exit(0);
    }
    
    public void updateTables(){
        partTable.refresh();
        productTable.refresh();
    }
}
