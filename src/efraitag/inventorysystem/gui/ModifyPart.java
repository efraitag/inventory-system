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
public class ModifyPart extends FXMLWindow{
    
    private final String PATH = "ModifyPart.fxml";
    private final String TITLE = "Modify Part";
    
    public ModifyPart() throws Exception{
        super.start(PATH, TITLE);
    }
}
