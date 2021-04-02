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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    @FXML private Label machineOrCompany;
    
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
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
            this.inHouse.setSelected(true);
            otherField.setText(Integer.toString(((InHouse)selectedPart).getMachineId()));
        }
        else if (selectedPart instanceof Outsourced){
            this.outsourced.setSelected(true);
            otherField.setText(((Outsourced)selectedPart).getCompanyName());
        }            
    }
    
    public void toggleContext(){
        if(this.inHouse.isSelected()){
            machineOrCompany.setText("Machine ID");
        }
        else{
            machineOrCompany.setText("Company Name");
        }
    }
    
    public void save(){
        
        try{
            Part toSave;
            
            if(this.inHouse.isSelected()){
                toSave = new InHouse(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(stockField.getText()),
                        Integer.parseInt(minField.getText()),
                        Integer.parseInt(maxField.getText()),
                        Integer.parseInt(otherField.getText()));
            }
            else{              
                toSave = new Outsourced(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Integer.parseInt(stockField.getText()),
                        Integer.parseInt(minField.getText()),
                        Integer.parseInt(maxField.getText()),
                        otherField.getText());
            }
            
            Inventory.updatePart(selectedPart);
            closeWindow();
            
        }
        //catches wrong types in the input fields
        catch(Exception e){
            new Alert(AlertType.ERROR, "One or more fields incorrect type.").showAndWait();
        }
    }
    
    /**
     * Closes the ModifyPart Window
     */
    public void closeWindow(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    
    
}
