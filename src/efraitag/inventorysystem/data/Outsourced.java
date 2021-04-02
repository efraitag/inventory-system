package efraitag.inventorysystem.data;

/**
 * @author Eden
 * This class describes a Part that is associated with an outsourced company
 */
public class Outsourced extends Part{

    private String companyName;

    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
    
    /**
     * 
     * @param companyName new name to set companyName as
     */
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    
    /**
     * 
     * @return name of company
     */
    public String getCompanyName(){
        return companyName;
    }
}
