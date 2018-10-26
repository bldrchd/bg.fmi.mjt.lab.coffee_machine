package bg.fmi.mjt.lab.coffee_machine.container;

import javax.naming.OperationNotSupportedException;

import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class BasicContainer extends Container {
    
    private static final double BASIC_CONTAINER_INITIAL_WATER = 600;
    private static final double BASIC_CONTAINER_INITIAL_COFFEE = 600;
    double water = BASIC_CONTAINER_INITIAL_WATER;
    double coffee = BASIC_CONTAINER_INITIAL_COFFEE;
    private boolean autoRefill;
    
    public BasicContainer() {
    }
    public BasicContainer(boolean autoRefill) {
        this.autoRefill = autoRefill;
    }

    @Override
    public double getCurrentWater() {
        return this.water;
    }

    @Override
    public double getCurrentMilk() {
        return 0;
    }

    @Override
    public double getCurrentCoffee() {
        return this.coffee;
    }

    @Override
    public double getCurrentCacao() {
        return 0;
    }
    
    public void useSupplies(Beverage beverage){
        this.water = this.water - beverage.getWater();
        this.coffee = this.coffee - beverage.getCoffee();
    }
    
    public void refill() throws OperationNotSupportedException { 
        if (autoRefill) {
            this.water = BASIC_CONTAINER_INITIAL_WATER;
            this.coffee = BASIC_CONTAINER_INITIAL_COFFEE;
        } else {
            throw new OperationNotSupportedException("Cannot Refil Containers.");
        }
    }
}
