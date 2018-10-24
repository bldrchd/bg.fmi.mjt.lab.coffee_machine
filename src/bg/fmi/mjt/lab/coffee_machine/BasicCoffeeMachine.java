package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class BasicCoffeeMachine implements CoffeeMachine{
   
    private boolean autoRefill = false;
    private double water;
    private double coffee;
    //doesn's supports cappucino and mochaccino 
    
    public BasicCoffeeMachine(){
        
    }
    public BasicCoffeeMachine(double water, double coffee)  {
        this.water = water;
        this.coffee = coffee;
    }

    @Override
    public Product brew(Beverage beverage) {
      //for each beverage(water coffee milk cacao) - try to make one as checking supplies,
      //if available - create new Product with stats from supplies
        try {
            getSupplies();
            Product p = new Product();
          
        } catch (Exception e){
            
        }
        return null;
    }

    @Override
    public Container getSupplies() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void refill() {
        if (autoRefill) {
            this.water = water; // BASIC_CONTAINER_INITIAL_WATER
        }
        
    }

}
