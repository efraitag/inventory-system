/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

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
    private int selectedIndex;
    
    @FXML
    public void initialize(){
        
    }
    
    public void setIndex(int index){
        selectedIndex = index;
        System.out.println(index);
    }
    
    
}
