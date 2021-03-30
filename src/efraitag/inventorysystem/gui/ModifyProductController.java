/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.Inventory;
import efraitag.inventorysystem.data.Part;
import efraitag.inventorysystem.data.Product;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
        selectedProduct = Inventory.lookupProduct(id);
        associatedParts = selectedProduct.getAllAssociatedParts();
        setValues();
    }
    
    public void setValues(){
        System.out.println(selectedProduct.getId());
        
        idField.setText(Integer.toString(selectedProduct.getId()));
        name.setText(selectedProduct.getName());
        price.setText(Double.toString(selectedProduct.getPrice()));
        inv.setText(Integer.toString(selectedProduct.getStock()));
        max.setText(Integer.toString(selectedProduct.getMax()));
        min.setText(Integer.toString(selectedProduct.getMin()));
        
        partsTable.setItems(Inventory.getAllParts());
        associatedPartsTable.setItems(associatedParts);
        
    }
}
