
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.Inventory;
import efraitag.inventorysystem.data.Part;
import efraitag.inventorysystem.data.Product;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Eden
 * This class controls the Modify Product window
 * FUTURE ENHANCEMENT share common functions with addProductController
 * by making them extend a common superclass
 */
public class ModifyProductController {
    
    @FXML private TextField idField;
    @FXML private TextField name;
    @FXML private TextField price;
    @FXML private TextField inv;
    @FXML private TextField max;
    @FXML private TextField min;
    @FXML private TextField searchField;
    
    @FXML private Button cancelButton;
    
    private ObservableList<Part> associatedParts;
    @FXML private TableView partsTable;
    @FXML private TableView associatedPartsTable;
    
    
    private int id;
    private Product selectedProduct;
    
    @FXML
    public void initalize(){
        
    }
    
    /**
     * 
     * @param id the of the product to modify
     * this function sets the associated product id
     * as well as calls setValues
     */
    public void setId(int id){
        this.id = id;
        setValues();
    }
    
    /**
     * This function fills all the text fields
     * with the data from the associated product
     */
    public void setValues(){
        
        selectedProduct = Inventory.lookupProduct(id);
        associatedParts = selectedProduct.getAllAssociatedParts();
        
        idField.setText(Integer.toString(selectedProduct.getId()));
        name.setText(selectedProduct.getName());
        price.setText(Double.toString(selectedProduct.getPrice()));
        inv.setText(Integer.toString(selectedProduct.getStock()));
        max.setText(Integer.toString(selectedProduct.getMax()));
        min.setText(Integer.toString(selectedProduct.getMin()));
        
        partsTable.setItems(Inventory.getAllParts());
        associatedPartsTable.setItems(associatedParts);
        
    }
    
    /**
     * This function searches the part table
     */
    public void doPartSearch(){
        String searchText = searchField.getText();
        
        if(searchText.equals("")){
            partsTable.setItems(Inventory.getAllParts());
        }
        
        ObservableList<Part> result = HomeController.partSearch(searchText);
        partsTable.setItems(result);
    }
    
    /**
     * This function associates a selected part with the
     * product being modified
     */
    public void addAssociatedPart(){
        ObservableList<Part> selectedParts = partsTable.getSelectionModel().getSelectedItems();
        Part selectedPart = selectedParts.get(0);
        
        if(selectedPart == null){
            new Alert(AlertType.ERROR, "No Part Selected.").showAndWait();
            return;
        }
        else{
            for(Part i:associatedParts){
                if(i == selectedPart){
                    new Alert(AlertType.ERROR, "Part already associated.").showAndWait();
                    return;
                }
            }
            associatedParts.add(selectedPart);
        }
    }
    
    /**
     * This function removes the selected associated part
     * from the product being modified
     */
    public void removeAssociatedPart(){
        ObservableList<Part> selectedAssociatedParts = associatedPartsTable.getSelectionModel().getSelectedItems();
        Part selectedAssociatedPart = selectedAssociatedParts.get(0);
        
        if(selectedAssociatedPart == null){
            new Alert(AlertType.ERROR, "No Associated Part Selected").showAndWait();
            return;
        }
        else{
           associatedParts.remove(selectedAssociatedPart);
        }
    }
    
    /**
     * This function closes the Modify Product window without closing the program
     */
    public void closeWindow(){
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }
    
    /**
    * checks if min<inv<max
    */
    public boolean errorCheck(){
        try{
            int min = Integer.parseInt(min.getText());
            int inv = Integer.parseInt(min.getText());
            int max = Integer.parseInt(min.getText());
        }
        catch (Exception e){
            new Alert(AlertType.ERROR, "Inventory fields are not numbers.").showAndWait();
            return true;
        }
        
        if(!(min<max)){
            new Alert(AlertType.ERROR, "Min must be less than max.").showAndWait();
            return true;
        }
        if(!(min<=inv && inv>=max)){
            new Alert(AlertType.ERROR, "Inventory must be between min and max.").showAndWait();
            return true;
        }
        
        return false;
    }
    
    /**
     * This function saves the entered information to the product being modified.
     * Additionally, before saving it checks for errors in the logic of the data.
     */
    public void save(){
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

                for(Part newPart: associatedParts){
                    newProduct.addAssociatedPart(newPart);
                }

                Inventory.updateProduct(Inventory.getAllProducts().indexOf(selectedProduct), newProduct);

                closeWindow();
            }catch (Exception e){
                new Alert(AlertType.ERROR, "One or more fields wrong Data Type.").showAndWait();
            }
        }
    }
}
