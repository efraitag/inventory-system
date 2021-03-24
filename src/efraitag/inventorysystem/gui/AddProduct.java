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
public class AddProduct extends FXMLWindow{
    
    private final String PATH = "AddProduct.fxml";
    private final String TITLE = "Add Product";
    
    public AddProduct() throws Exception{
        super.start(PATH, TITLE);
    }
    
}
