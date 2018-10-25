package bg.fmi.mjt.lab.coffee_machine.supplies;

public class Cappuccino implements Beverage {

    private String name = "Cappucino";
    private int coffee = 18;
    private int milk = 150;
    
    public Cappuccino() {
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getMilk() {
        return this.milk;
    }

    @Override
    public double getCoffee() {
        return this.coffee;
    }

    @Override
    public double getWater() {
        return 0;
    }

    @Override
    public double getCacao() {
        return 0;
    }


}
