package bg.fmi.mjt.lab.coffee_machine.container;

import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class PremiumContainer extends Container {

    public static final double PREMIUM_CONTAINER_INITIAL_WATER = 1000;
    public static final double PREMIUM_CONTAINER_INITIAL_COFFEE = 1000;
    public static final double PREMIUM_CONTAINER_INITIAL_MILK = 1000;
    public static final double PREMIUM_CONTAINER_INITIAL_CACAO = 300;
    private double water = PREMIUM_CONTAINER_INITIAL_WATER;
    private double coffee = PREMIUM_CONTAINER_INITIAL_COFFEE;
    private double milk = PREMIUM_CONTAINER_INITIAL_MILK;
    private double cacao = PREMIUM_CONTAINER_INITIAL_CACAO;

    public PremiumContainer() {
    }

    @Override
    public double getCurrentWater() {
        return this.water;
    }

    @Override
    public double getCurrentMilk() {
        return this.milk;
    }

    @Override
    public double getCurrentCoffee() {
        return this.coffee;
    }

    @Override
    public double getCurrentCacao() {
        return this.cacao;
    }

    public void useSupplies(Beverage beverage) {
        this.water = this.water - beverage.getWater();
        this.coffee = this.coffee - beverage.getCoffee();
        this.milk = this.milk - beverage.getMilk();
        this.cacao = this.cacao - beverage.getCacao();
    }
}
