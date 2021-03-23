/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.InHouse;
import efraitag.inventorysystem.data.Inventory;
import efraitag.inventorysystem.data.Outsourced;
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
public class AddPartController {
    
    @FXML
    private RadioButton inHouse;
    @FXML
    private RadioButton outsourced;
    @FXML
    private Label machineOrCompany;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField name;
    @FXML
    private TextField inv;
    @FXML
    private TextField price;
    @FXML
    private TextField max;
    @FXML
    private TextField min;
    @FXML
    private TextField other;

  
    public void AddPartController(){
        
    }
    
    @FXML
    public void initialize(){
    }
    
    /**
     * Sets the last textfield to different text depending on the type of part being added
     */
    public void toggleContext(){
        if (inHouse.isSelected()){
            machineOrCompany.setText("Machine ID");
        }
        else{
            machineOrCompany.setText("Company Name");
        }
    }
    
    /**
     * Closes the AddPart window, discarding all changes
     */
    public void closeWindow(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        System.out.println(Inventory.getAllParts());
        stage.close();
    }
    
    /**
     * Creates new Part from user input and adds it to inventory.
     * Will send error message if a field is blank or incorrectly formatted.
     */
    public void save(){
        int id = generateId();
        
        try{
            if(inHouse.isSelected()){
                Inventory.addPart(new InHouse(
                        id,
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        Integer.parseInt(inv.getText()),
                        Integer.parseInt(min.getText()),
                        Integer.parseInt(max.getText()),
                        Integer.parseInt(other.getText())));
            }
            else{
                Inventory.addPart(new Outsourced(
                        id,
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        Integer.parseInt(inv.getText()),
                        Integer.parseInt(min.getText()),
                        Integer.parseInt(max.getText()),
                        other.getText())); 
            }
            closeWindow();
        }
        catch(Exception e){
            new Alert(AlertType.ERROR, e.toString()).showAndWait();
        }
    }
    
    public int generateId(){
        return Inventory.getAllParts().size() + 1;
    }
    
}
