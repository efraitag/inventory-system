/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package efraitag.inventorysystem.gui;

/**
 *
 * @author Eden
 */
public class ModifyProduct extends FXMLWindow{
    
    private final String PATH = "ModifyProduct.fxml";
    private final String TITLE = "Modify Product";
    
    public ModifyProduct() throws Exception{
        super.start(PATH, TITLE);
    }
    
}
