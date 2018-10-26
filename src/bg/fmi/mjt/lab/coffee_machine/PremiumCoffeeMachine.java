package bg.fmi.mjt.lab.coffee_machine;

import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.container.PremiumContainer;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public class PremiumCoffeeMachine implements CoffeeMachine {
    boolean autoRefill = true;
    private boolean supportedLuck = true;
    private double availableWater;
    private double availableCoffee;
    private double availableMilk;
    private double availableCacao;
    private int espressoQuantity = 0;
    private int cappuccinoQuantity = 0;
    private int mochaccinoQuantity = 0;
    PremiumContainer pc;

    /**
     * @param autoRefill
     *            - if true, it will automatically refill the container if there
     *            are not enough ingredients to make the coffee drink
     */
    public PremiumCoffeeMachine(boolean autoRefill) {
    }

    /**
     * If quantity is <= 0 or the quantity is not supported for the particular
     * Coffee Machine the method returns null
     */
    public Product brew(Beverage beverage, int quantity) {
        Product p = null;
        if (quantity < 1 || quantity > 3) {
            return null;
        } else {
            for (int i = 0; i < quantity; i++) {
                if (beverage.getName() == "Espresso") {
                    getSupplies();
                    if ((availableCoffee < beverage.getCoffee()) || (availableWater < beverage.getWater())) {
                        refill();
                    } else {
                        pc.useSupplies(beverage);
                        espressoQuantity += 1;
                        p = new Product(beverage, supportedLuck, espressoQuantity);
                    }
                } else if (beverage.getName() == "Cappuccino") {
                    if (availableMilk < beverage.getMilk() || availableCoffee < beverage.getCoffee()) {
                        refill();
                    } else {
                        pc.useSupplies(beverage);
                        cappuccinoQuantity += 1;
                        p = new Product(beverage, supportedLuck, cappuccinoQuantity);
                    }
                } else if (beverage.getName() == "Mochaccino") {
                    if (availableMilk < beverage.getMilk() || availableCoffee < beverage.getCoffee()
                            || availableCacao < beverage.getCacao()) {
                        refill();
                    } else {
                        pc.useSupplies(beverage);
                        mochaccinoQuantity += 1;
                        p = new Product(beverage, supportedLuck, mochaccinoQuantity);
                    }
                }
            }
        }
        return p;
    }

    public PremiumCoffeeMachine() {
        pc = new PremiumContainer();
    }

    @Override
    public Product brew(Beverage beverage) {
       return brew(beverage, 1);
    }

    @Override
    public Container getSupplies() {
        availableCoffee = pc.getCurrentCoffee();
        System.out.println("C:"+availableCoffee);
        availableWater = pc.getCurrentWater();
        System.out.println("W:"+availableWater);
        availableMilk = pc.getCurrentMilk();
        availableCacao = pc.getCurrentCacao();
        return pc;
    }

    @Override
    public void refill() {
        pc.refill();
    }

}
