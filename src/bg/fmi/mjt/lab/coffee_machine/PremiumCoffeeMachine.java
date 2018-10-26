package bg.fmi.mjt.lab.coffee_machine;

import javax.naming.OperationNotSupportedException;

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
        pc = new PremiumContainer();
        this.autoRefill = autoRefill;
    }

    /**
     * If quantity is <= 0 or the quantity is not supported for the particular
     * Coffee Machine the method returns null
     * @throws OperationNotSupportedException 
     */
    public Product brew(Beverage beverage, boolean supportedLuck, int quantity) throws OperationNotSupportedException {
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
       try {
        return brew(beverage, supportedLuck, 1);
    } catch (OperationNotSupportedException one) {
        one.printStackTrace();
    }
    return null;
    }

    @Override
    public Container getSupplies() {
        availableCoffee = pc.getCurrentCoffee();
        availableWater = pc.getCurrentWater();
        availableMilk = pc.getCurrentMilk();
        availableCacao = pc.getCurrentCacao();
        return pc;
    }

    @Override
    public void refill() throws OperationNotSupportedException {
        if (autoRefill) {
            this.availableWater = PremiumContainer.PREMIUM_CONTAINER_INITIAL_WATER;
            this.availableCoffee = PremiumContainer.PREMIUM_CONTAINER_INITIAL_COFFEE;
            this.availableMilk = PremiumContainer.PREMIUM_CONTAINER_INITIAL_MILK;
            this.availableCacao = PremiumContainer.PREMIUM_CONTAINER_INITIAL_CACAO;
        } else {
            throw new OperationNotSupportedException("Cannot Refil Containers.");
        }
    }

}
