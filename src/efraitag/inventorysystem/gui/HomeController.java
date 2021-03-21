/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 * FUTURE ENHANCEMENT handle Exceptions with more than just a system.out
 * @author Eden
 */
public class HomeController {
    
    public void HomeController() {
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
        //TODO
    }
    
    /**
     * 
     */
    public void exitApplication(){
        //TODO
    }
}
