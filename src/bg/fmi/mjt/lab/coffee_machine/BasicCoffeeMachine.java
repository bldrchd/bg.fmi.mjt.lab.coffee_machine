package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.BasicContainer;
import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

import javax.naming.OperationNotSupportedException;

import bg.fmi.mjt.lab.coffee_machine.CoffeeMachine;
import bg.fmi.mjt.lab.coffee_machine.Product;

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
                    return null;
                } else if (availableWater < beverage.getWater()) {
                    return null;
                } else {
                    bc.useSupplies(beverage);
                    espressoQuantity++;
                    p = new Product(beverage, supportedLuck, espressoQuantity);
                }
            } else {
                return null;
            }
        } catch (Exception e) {

        }
        return p;
    }

    @Override
    public Container getSupplies() {
        availableCoffee = bc.getCurrentCoffee();
        availableWater = bc.getCurrentWater();
        return bc;
    }

    public void refill() throws OperationNotSupportedException {
        bc.refill();
    }

}
