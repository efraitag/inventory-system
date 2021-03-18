package efraitag.inventorysystem.data;

import javafx.collections.ObservableList;

public class Product {
    private ObservableList<Part> associatedParts;
    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    public Product(int id, String name, double price, int stock, int min, int max){
        //TODO
    }

    public void setId(int id){
        //TODO
    }

    public void setName(String Name){
        //TODO
    }

    public void setPrice(double price){
        //TODO
    }

    public void setStock(int stock){
        //TODO
    }

    public void setMin(int min){
        //TODO
    }

    public void setMax(int max){
        //TODO
    }

    public int getId(){
        //TODO
        return -1;
    }

    public String getName(){
        //TODO
        return "";
    }

    public double getPrice(){
        //TODO
        return -1;
    }

    public int getStock(){
        //TODO
        return -1;
    }

    public int getMin(){
        //TODO
        return -1;
    }

    public int getMax(){
        //TODO
        return -1;
    }

    public void addAssociatedPart(Part part){
        //TODO
    }

    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
        //TODO
        return false;
    }

    public ObservableList<Part> getAllAssociatedParts(){
        //TODO
        return null;
    }

}
