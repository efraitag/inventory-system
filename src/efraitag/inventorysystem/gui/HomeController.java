
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
 * FUTURE ENHANCEMENT move the static methods to Inventory or FXMLWindow
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
     * @param searchText the string to search partList for
     * @return an ObservableList containing one Part if the
     * passed String is an Id, otherwise returns a list of all
     * the Parts with names that contain searchText
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
     * Sets the Parts Table to the output of partSearch
     */
    public void doPartSearch(){
        String searchText = partSearch.getText();
        partTable.setItems(partSearch(searchText));       
    }
    
    /**
     * This method opens the Add Part window
     *
     * RUNTIME ERROR file not found exceptions from AddPart constructor were not handled,
     * so it was surrounded in a try catch statement
     */
    public void openAddPart(){
        try{
            FXMLWindow window = new AddPart();
        }
        catch(Exception e){
            new Alert(AlertType.ERROR, "File not found.").showAndWait();
        }
    }
    
    /**
     * This method opens the Modify Part window
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
     * This method deletes a Part from the partTable that the user has selected
     */
    public void deletePart(){
        Part selectedPart = partTable.getSelectionModel().getSelectedItem();
        Inventory.deletePart(selectedPart);
    }
    
    /**
     * 
     * @param searchText the string to search the productList for
     *
     * @return returns an ObservableList that contains one Product if
     * the passed string is an id, otherwise returns a list of all Products
     * with the passed string in their name
     *
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
     * Updates the productTable with the results of productSearch
     */
    public void doProductSearch(){
        String searchText = productSearch.getText();
        productTable.setItems(productSearch(searchText));
    }
    
    /**
     * This method opens the Add Product window
     */
    public void openAddProduct(){
        try{
            FXMLWindow window = new AddProduct();
        } catch(Exception e){}
    }
    
    /**
     * This method oepns the modify product window
     */
    public void openModifyProduct(){
        try{
            int id = productTable.getSelectionModel().getSelectedItems().get(0).getId();
            FXMLWindow window = new ModifyProduct(id);
        } catch(Exception e){}
    }
    
    /**
     * This method deletes a Product from the Product Table that the user has selected
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
     * UNUSED This method exits the entire application
     */
    public void exitApplication(){
        //TODO Save before exit
        System.exit(0);
    }
    
    /**
      * UNUSED this method updates the Part and Product tables
     */
    public void updateTables(){
        partTable.refresh();
        productTable.refresh();
    }
}
