package bg.fmi.mjt.lab.coffee_machine.container;

import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class BasicContainer extends Container {
    
    private static final double BASIC_CONTAINER_INITIAL_WATER = 600;
    private static final double BASIC_CONTAINER_INITIAL_COFFEE = 600;
    double water = BASIC_CONTAINER_INITIAL_WATER;
    double coffee = BASIC_CONTAINER_INITIAL_COFFEE;
    
    public BasicContainer() {
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
        this.coffee = this.water - beverage.getCoffee();
    }
}
