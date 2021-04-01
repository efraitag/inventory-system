/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void setId(int id){
        this.id = id;
        setValues();
    }
    
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
    
    public void doPartSearch(){
        String searchText = searchField.getText();
        
        if(searchText.equals("")){
            partsTable.setItems(Inventory.getAllParts());
        }
        
        ObservableList<Part> result = HomeController.partSearch(searchText);
        partsTable.setItems(result);
    }
    
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
    
    public void closeWindow(){
        Stage s = (Stage) cancelButton.getScene().getWindow();
        s.close();
    }
    
    public void save(){
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
    }
}
