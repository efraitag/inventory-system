package efraitag.inventorysystem.data;

import javafx.collections.ObservableList;

public class Inventory {

    private static ObservableList<Part> allParts;
    private static ObservableList<Product> allProducts;

    public static void addPart(Part newPart){
        //TODO
        return;
    }

    public static void addProduct(Product newProduct){
        //TODO
        return;
    }

    public static Part lookupPart(int partId){
        //TODO
        return null;
    }

    public static Product lookupProduct(int productId){
        //TODO
        return null;
    }

    public static ObservableList<Part> lookupPart(String partName){
        //TODO
        return null;
    }

    public static ObservableList<Product> lookupProduct(String productName){
        //TODO
        return null;
    }

    public static void updatePart( int index, Part selectedPart){
        //TODO
        return;
    }

    public static void updateProduct(int index, Product newProduct){
        //TODO
        return;
    }

    public static boolean deletePart(Part selectedPart){
        //TODO
        return false;
    }

    public static boolean deleteProduct(Product selectedProduct){
        //TODO
        return false;
    }

    public static ObservableList<Part> getAllParts(){
        //TODO
        return null;
    }

    public static ObservableList<Product> getAllProducts(){
        //TODO
        return null;
    }

}
