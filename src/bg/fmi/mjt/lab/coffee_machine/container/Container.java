package bg.fmi.mjt.lab.coffee_machine.container;

public abstract class Container {
    private static final double BASIC_CONTAINER_INITIAL_WATER = 600;
    private static final double BASIC_CONTAINER_INITIAL_COFFEE = 600;
    private static final double PREMIUM_CONTAINER_INITIAL_WATER = 1000;
    private static final double PREMIUM_CONTAINER_INITIAL_COFFEE = 1000;
    
    public Container() {
    }
    /**
    * Returns the current quantity (in milliliters) of the water in the container
    */
    abstract public double getCurrentWater();

    /**
    * Returns the current quantity (in milliliters) of the milk in the container
    */
    abstract public double getCurrentMilk();

    /**
    * Returns the current quantity (in grams) of the coffee in the container
    */
    abstract public double getCurrentCoffee();

    /**
    * Returns the current quantity (in grams) of the cacao in the container
    */
    abstract public double getCurrentCacao();
}
