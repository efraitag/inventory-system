
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.Inventory;
import efraitag.inventorysystem.data.Part;
import efraitag.inventorysystem.data.Product;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Eden
 * This class controls the AddProduct window
 * FUTURE ENHANCEMENT make the main window disappear while this is active
 */
public class AddProductController{
    
    @FXML private TextField name;
    @FXML private TextField inv;
    @FXML private TextField price;
    @FXML private TextField max;
    @FXML private TextField min;
    @FXML private Button cancelButton;
    
    @FXML private TextField searchBar;
    @FXML private TableView partsTable;
    @FXML private TableView associatedPartsTable;
    
    private TableViewSelectionModel partsTableSelectionModel;
    private TableViewSelectionModel associatedPartsTableSelectionModel;
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList(new ArrayList<Part>());
    
    /**
     * initializes the Part tables
     */
    @FXML
    public void initialize(){
        partsTable.setItems(Inventory.getAllParts());
        partsTableSelectionModel = partsTable.getSelectionModel();
        associatedPartsTable.setItems(associatedParts);
        associatedPartsTableSelectionModel = associatedPartsTable.getSelectionModel();
    }
    
    /**
     * Adds a Part to the current associated parts list
     */
    public void addAssociatedPart(){
        ObservableList<Part> newAssociatedPart = partsTableSelectionModel.getSelectedItems();
        
        //check if selection is empty
        if(!(newAssociatedPart.isEmpty())){
            
            //check if part already associated with product
            for(Part associatedPart: associatedParts){
                if(associatedPart.getId() == newAssociatedPart.get(0).getId()){
                    new Alert(Alert.AlertType.ERROR, "Part already associated!").showAndWait();
                    return;
                }
            }
            
            //add to the table
            associatedParts.add(newAssociatedPart.get(0));
        }
        //if the part selection is empty, display error.
        else{
            new Alert(AlertType.ERROR, "Selection is Empty.").showAndWait();
        }
    }
    
    /**
     * Removes the selected associated part from the associated part list
     */
    public void removeAssociatedPart(){
        Part toDelete;
        
        try{
            toDelete = (Part) associatedPartsTable.getSelectionModel().getSelectedItems().get(0);
        } catch(IndexOutOfBoundsException e){
            new Alert(AlertType.ERROR, "Please select a Part to disassociate").showAndWait();
            return;
        }
        
        if(toDelete != null){
            Alert alert = new Alert(AlertType.CONFIRMATION, "Are you sure you want to delete " + toDelete.getName() + "?");
            alert.showAndWait().ifPresent(response ->{
                if(response == ButtonType.OK){
                    associatedParts.remove(toDelete);
                }
            });
        }
    }
    
    /**
     * This function checks whether min<inv<max
     * @return true if it finds errors, false otherwise
     */
    public boolean errorCheck(){
             
        int minVal;
        int invVal;
        int maxVal;
        
        
        try{
            minVal = Integer.parseInt(min.getText());
            invVal = Integer.parseInt(inv.getText());
            maxVal = Integer.parseInt(max.getText());
        }
        catch (Exception e){
            new Alert(AlertType.ERROR, "Inventory fields are not numbers.").showAndWait();
            return true;
        }
        
        if(minVal == 0 || maxVal == 0 || invVal == 0){
            new Alert(AlertType.ERROR, "One or more inventory values zero.").showAndWait();
            return true;
        }
        
        if(!(minVal<=maxVal)){
            new Alert(AlertType.ERROR, "Min must be less than max.").showAndWait();
            return true;
        }
        if(!(minVal<=invVal && invVal<=maxVal)){
            new Alert(AlertType.ERROR, "Inventory must be between min and max.").showAndWait();
            return true;
        }
        
        return false;
    }
    
    /**
     * saves new part and closes window
     * id is auto generated based on the size of the product list in Inventory
     */
    public void save(){
        int id = Inventory.getAllProducts().size() + 1;
        boolean areErrors = errorCheck();
        
        if(!areErrors){
            try{
                Product newProduct = new Product(
                                id,
                                name.getText(),
                                Double.parseDouble(price.getText()),
                                Integer.parseInt(inv.getText()),
                                Integer.parseInt(min.getText()),
                                Integer.parseInt(max.getText()));

                for(Part associatedPart: associatedParts){
                    newProduct.addAssociatedPart(associatedPart);
                }

                Inventory.addProduct(newProduct);
                closeWindow();
            } catch (Exception e) {
                new Alert(AlertType.ERROR, "One or more fields incorrect Data Type.").showAndWait();
            }
        }
    }
    
    /**
     * closes current window without exiting program
     */
    public void closeWindow(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Sorts Part table based on user input
     */
    public void doPartSearch(){
        String searchText = searchBar.getText();
        partsTable.setItems(HomeController.partSearch(searchText));
    }
}
