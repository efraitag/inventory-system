package efraitag.inventorysystem.data;

import javafx.collections.ObservableList;
import javafx.collections.*;
import java.util.ArrayList;

public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList(new ArrayList<Part>());
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList(new ArrayList<Product>());
    
    /**
     * 
     * @param newPart the part to add
     */
    public static void addPart(Part newPart){
        allParts.add(newPart);
    }
    
    /**
     * 
     * @param newProduct the product to add
     */
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }
    
    /**
     * 
     * @param partId id of part to look up
     * @return the part with the given id, null if none was found
     */
    public static Part lookupPart(int partId){
        for ( Part i : allParts ){
            if (i.getId() == partId){
                return i;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param productId id of product to look up
     * @return the product with the given id, null if none was found
     */
    public static Product lookupProduct(int productId){
        for (Product i : allProducts){
            if (i.getId() == productId){
                return i;
            }
        }
        return null;
    }
    
    /**
     * 
     * @param partName part name to look up
     * @return list of all parts with given name, null otherwise
     */
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> out = FXCollections.observableArrayList(new ArrayList<Part>());
        
        for (Part i : allParts){
            if (i.getName().equals(partName)){
                out.add(i);
            }
        }
        
        if (out.isEmpty()){
            return null;
        }
        else{
            return out;
        }
    }
    
    /**
     * 
     * @param productName product name to look up
     * @return list of all products with given name, null otherwise
     */
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> out = FXCollections.observableArrayList(new ArrayList<Product>());
        
        for (Product i: allProducts){
            if (i.getName().equals(productName)){
                out.add(i);
            }
        }
        
        if (out.isEmpty()){
            return null;
        }
        else{
            return out;
        }
        
    }
    
    /**
     * 
     * @param index index of allParts
     * @param selectedPart new Part to set
     */
    public static void updatePart( int index, Part selectedPart){
        allParts.set(index, selectedPart);
    }
    
    /**
     * 
     * @param index index of allProducts
     * @param newProduct new Product to set
     */
    public static void updateProduct(int index, Product newProduct){
        allProducts.set(index, newProduct);
    }
    
    /**
     * 
     * @param selectedPart Part to delete
     * @return true if deleted, false otherwise
     */
    public static boolean deletePart(Part selectedPart){
        return allParts.remove(selectedPart);
    }

    /**
     * 
     * @param selectedProduct Product to delete
     * @return true if deleted, false otherwise
     */
    public static boolean deleteProduct(Product selectedProduct){
        return allProducts.remove(selectedProduct);
    }

    /**
     * 
     * @return copy of allParts
     */
    public static ObservableList<Part> getAllParts(){
        return FXCollections.observableArrayList(new ArrayList<Part>(allParts));
    }

    /**
     * 
     * @return copy of allProducts
     */
    public static ObservableList<Product> getAllProducts(){
        return FXCollections.observableArrayList(new ArrayList<Product>(allProducts));
    }

}
