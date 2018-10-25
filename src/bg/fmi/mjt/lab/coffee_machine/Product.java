package bg.fmi.mjt.lab.coffee_machine;

import java.util.ArrayList;

import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class Product {

    private String name;
    private int quantity;
    private boolean supported = false;
    private int i=0;
    private ArrayList<String> lucks = new ArrayList<String>() {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        {
            add("If at first you don't succeed call it version 1.0.");
            add("Today you will make magic happen!");
            add("Have you tried turning it off and on again?");
            add("Life would be much more easier if you had the source code.");
        }
    };

    public Product() {
        if (supported){
            getLuck();
        }
    }

    public Product(Beverage beverage, boolean supported, int quantity){
        setName(beverage.getName());
    }
    
    public String getName() {
        return this.name;
    }
    public void setName(String beverageName){
        this.name = beverageName;
    }
    
    public int getQuantity() {
        return this.quantity;
    }

    public String getLuck() {
        String luck = null;
        if (supported) {
            if ( i > lucks.size()){
                i = 0;
             }
           luck = lucks.get(i);
           i++;
        }
        return luck;
    }

    public boolean getSupportLuck() {
        return supported;
    }

    public void setSupportedLuck(boolean supported) {
        this.supported = supported;
    }
    public void setQuantity(int machineQuantity){
        this.quantity = machineQuantity;
    }
}
