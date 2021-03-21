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
public class AddPart extends FXMLWindow{
    
    private final String PATH = "AddPart.fxml";
    private final String TITLE = "Add Part";
    
    public AddPart() throws Exception{
        super.start(PATH, TITLE);
    }
    
}
