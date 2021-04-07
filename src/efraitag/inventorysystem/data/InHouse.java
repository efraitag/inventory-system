package efraitag.inventorysystem.data;

/**
 * @author Eden
 */

/**
 * 
 * This class describes a Part associated with an in-house machine
 */

public class InHouse extends Part{

    private int machineId;
    
    /**
     * 
     * @param id part id
     * @param name part name
     * @param price cost of part
     * @param stock inventory on hand
     * @param min min to have on hand
     * @param max max to have on hand
     * @param machineId id of the machine that makes it
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId){
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }
    
    /**
     * 
     * @param machineId Id to set machineId to
     */
    public void setMachineId(int machineId){
        this.machineId = machineId;
    }
    
    /**
     * 
     * @return the machineId
     */
    public int getMachineId(){
        return machineId;
    }

}
