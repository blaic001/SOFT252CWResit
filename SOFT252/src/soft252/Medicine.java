/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252;

/**
 *
 * @author charl
 */
public class Medicine {

    protected String name = "";
    protected int quantity = 0;
    protected String dosage = "";
    
    public Medicine(String name, int quantity, String dosage){
        this.name = name;
        this.quantity = quantity;
        this.dosage = dosage;
    }
    
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    public String getDosage() {
        return dosage;
    }
    
    
}

