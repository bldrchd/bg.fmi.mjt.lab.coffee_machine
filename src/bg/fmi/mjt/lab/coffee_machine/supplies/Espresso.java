package bg.fmi.mjt.lab.coffee_machine.supplies;

public class Espresso implements Beverage {
    
    private String name = "Espresso";
    private int coffee = 10;
    private int water = 30;
    
    public Espresso(int coffee, int water) {
        this.coffee = coffee;
        this.water = water;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getMilk() {
        return 0;
    }

    @Override
    public double getCoffee() {
        return this.coffee;
    }

    @Override
    public double getWater() {
        return this.water;
    }

    @Override
    public double getCacao() {
        return 0;
    }

}
