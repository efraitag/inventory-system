package efraitag.inventorysystem.data;

public class InHouse extends Part{

    private int machineId;

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId){
        super(id, name, price, stock, min, max);
        //TODO
    }

    public void setMachineId(int machineId){
        //TODO
        return;
    }

    public int getMachineId(){
        //TODO
        return -1;
    }

}
