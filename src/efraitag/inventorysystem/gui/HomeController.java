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
import javafx.scene.control.TableView;
import javafx.fxml.FXML;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 * FUTURE ENHANCEMENT handle Exceptions with more than just a system.out
 * @author Eden
 */
public class HomeController {
    
    @FXML
    private TableView<Part> partTable;
    @FXML
    private TableView<Product> productTable;
    @FXML
    private TextField partSearch;
    @FXML
    private TextField productSearch;
    
    private TableViewSelectionModel partTableSelectionModel;
    private TableViewSelectionModel productTableSelectionModel;
    private ObservableList partTableCols;
    private ObservableList productTableCols;
    
    public void HomeController() {
        //pass
    }
    
    @FXML
    public void initialize(){
        partTableSelectionModel = partTable.getSelectionModel();
        productTableSelectionModel = productTable.getSelectionModel();
        //TODO: Populate tables with data from file
        //TODO: !!Inventory initializes with data from file
        //table.setItems(Inventory.getAllParts());
    }
    
    /**
     * 
     */
    public void doPartSearch(){
        String searchText = partSearch.getText();
        ObservableList<Part> resultList = FXCollections.observableArrayList(new ArrayList<>());
        
        //if blank, reset to default
        if(searchText.equals("")){
            //TODO: reset table values to default
        }
        
        //if contains a digit, try and parse
        if(searchText.matches("\\d")){
            try{
                resultList.setAll(Inventory.lookupPart(Integer.parseInt(searchText)));
            }
            catch(Exception e){
                //is mixed, please enter either ID or name
                System.out.println(e);
            }
        }
        
        //if just a name, search names and populate table
        else{
            resultList = Inventory.lookupPart(searchText);
        }
        
        //now iterate through resultList and populate table with it
        //TODO: Table.setItems(resultList);
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
    public void doProductSearch(){
        //TODO
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
        //TODO Save before exit
        System.exit(0);
    }
}
