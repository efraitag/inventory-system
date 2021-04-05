
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
 * @author Eden
 * This class controls the AddPart Window
 * FUTURE ENHANCEMENT make the main window disappear when this opens
 */
public class AddPartController {
    
    @FXML private RadioButton inHouse;
    @FXML private Label machineOrCompany;
    @FXML private Button cancelButton;
    @FXML private TextField name;
    @FXML private TextField inv;
    @FXML private TextField price;
    @FXML private TextField max;
    @FXML private TextField min;
    @FXML private TextField other;
    
    /**
     * Sets the last textfield to different text depending on the type of part being added
     * RUNTIME ERROR initially, the radio buttons were not part of the same togglegroup.
     * this was fixed by manually editing the FXML code that was imported from scene builder.
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
        stage.close();
    }
    
    /**
    * This function checks whether the min<inv<max
    *
    */
    public boolean errorCheck(){
        try{
            int min = Integer.parseInt(min.getText());
            int inv = Integer.parseInt(min.getText());
            int max = Integer.parseInt(min.getText());
        }
        catch (Exception e){
            new Alert(AlertType.ERROR, "Inventory fields are not numbers.").showAndWait();
            return true;
        }
        
        if(!(min<max)){
            new Alert(AlertType.ERROR, "Min must be less than max.").showAndWait();
            return true;
        }
        if(!(min<=inv && inv>=max)){
            new Alert(AlertType.ERROR, "Inventory must be between min and max.").showAndWait();
            return true;
        }
        
        return false;
    }
    
    /**
     * Creates new Part from user input and adds it to inventory.
     * Will send error message if a field is blank or incorrectly formatted.
     */
    public void save(){
        int id = generateId();
        boolean areErrors = errorCheck();
        
        if(!areErrors){
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
            //Catches if incorrect types in the input fields
            catch(Exception e){
                new Alert(AlertType.ERROR, "One or more fields have incorrect types.").showAndWait();
            }
        }
    }
    
    /**
     * 
     * @return returns a unique id based on the size of the Part list in Inventory 
     */
    public int generateId(){
        return Inventory.getAllParts().size() + 1;
    }
    
}
