package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class PremiumCoffeeMachine implements CoffeeMachine {
    boolean autoRefill = true;
    /**
    * @param autoRefill - if true, it will automatically refill the container
    * if there are not enough ingredients to make the coffee drink
    */
    public PremiumCoffeeMachine(boolean autoRefill){}
    
    /**
    * If quantity is <= 0 or the quantity is not supported for
    * the particular Coffee Machine the method returns null
    */
    public Product brew(Beverage beverage, int quantity){
        return null;
    }
    
    public PremiumCoffeeMachine() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Product brew(Beverage beverage) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Container getSupplies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refill() {
        // TODO Auto-generated method stub
        
    }


}
