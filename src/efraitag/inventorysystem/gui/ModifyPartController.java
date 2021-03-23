/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.InHouse;
import efraitag.inventorysystem.data.Inventory;
import efraitag.inventorysystem.data.Outsourced;
import efraitag.inventorysystem.data.Part;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author Eden
 */
public class ModifyPartController {
    
    @FXML private RadioButton inHouse;
    @FXML private RadioButton outsourced;
    
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField stockField;
    @FXML private TextField priceField;
    @FXML private TextField minField;
    @FXML private TextField maxField;
    @FXML private TextField otherField;
    
    private Part selectedPart;
    private int selectedId;
    
    @FXML
    public void initialize(){
        
    }
    
    public void setId(int id){
        selectedId = id;
        selectedPart = Inventory.lookupPart(id);
        
        setTextFieldValues();
    }
    
    public void setTextFieldValues(){
        idField.setText(Integer.toString(selectedPart.getId()));
        nameField.setText(selectedPart.getName());
        stockField.setText(Integer.toString(selectedPart.getStock()));
        priceField.setText(Double.toString(selectedPart.getPrice()));
        minField.setText(Integer.toString(selectedPart.getMin()));
        maxField.setText(Integer.toString(selectedPart.getMax()));
        
        if (selectedPart instanceof InHouse){
            //TODO how to make it so its an inhouse or outsourced??
            otherField.setText(Integer.toString(selectedPart.getMachineId()));
        }
        else if (selectedPart instanceof Outsourced){
        }
        
        
    }
    
    
}
