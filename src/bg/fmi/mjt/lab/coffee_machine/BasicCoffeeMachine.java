package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.BasicContainer;
import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class BasicCoffeeMachine implements CoffeeMachine {

    private boolean supportedLuck = false;
    private double availableWater;
    private double availableCoffee;
    private int espressoQuantity = 0;
    private BasicContainer bc;

    public BasicCoffeeMachine() {
        bc = new BasicContainer();
    }

    @Override
    public Product brew(Beverage beverage) {
        Product p = null;
        try {
            if (beverage.getName() == "Espresso") {
                getSupplies();
                if (availableCoffee < beverage.getCoffee()) {
                    System.out.println("C:"+ availableCoffee);
                    return null;
                } else if (availableWater < beverage.getWater()) {
                    System.out.println("w:"+availableWater);
                    return null;
                } else {
                    bc.useSupplies(beverage);
                    if (beverage.getName() == "Espresso") {
                        espressoQuantity += 1;
                        p = new Product(beverage, supportedLuck, espressoQuantity);
                    }
                }
            } else {return null;}
        } catch (Exception e) {

        }
        return p;
    }

    @Override
    public Container getSupplies() {
        availableCoffee = bc.getCurrentCoffee();
        availableWater = bc.getCurrentWater();
        System.out.println("Co" + availableCoffee);
        System.out.println("Wa"+ availableWater);
        return bc;
    }

    @Override
    public void refill() {
    }

}
