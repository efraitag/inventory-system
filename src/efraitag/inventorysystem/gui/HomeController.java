/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import efraitag.inventorysystem.data.Part;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableView.TableViewSelectionModel;

/**
 * FXML Controller class
 * FUTURE ENHANCEMENT handle Exceptions with more than just a system.out
 * @author Eden
 */
public class HomeController {
    
    @FXML
    private TableView partTable;
    @FXML
    private TableView productTable;
    private TableViewSelectionModel partTableSelectionModel;
    private TableViewSelectionModel productTableSelectionModel;
    
    public void HomeController() {
        //pass
    }
    
    @FXML
    public void initialize(){
        partTableSelectionModel = partTable.getSelectionModel();
        productTableSelectionModel = productTable.getSelectionModel();
        //TODO: Populate tables with data from file
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
            FXMLWindow window = new ModifyPart();
        } catch(Exception e) {}
    }
    
    /**
     * 
     */
    public void deletePart(){
        ObservableList<Integer> selectedPart = partTableSelectionModel.getSelectedIndices();
        
        if(selectedPart == null){
            //TODO Error pop-up
            return;
        }
        else{
            partTable.getItems().remove(selectedPart.get(0));
        }
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
            FXMLWindow window = new ModifyProduct();
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
        System.exit(0);
    }
}
