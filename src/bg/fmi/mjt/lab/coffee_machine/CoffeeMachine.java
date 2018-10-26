package bg.fmi.mjt.lab.coffee_machine;

import javax.naming.OperationNotSupportedException;

import bg.fmi.mjt.lab.coffee_machine.container.Container;
import bg.fmi.mjt.lab.coffee_machine.supplies.Beverage;

public interface CoffeeMachine {
    /**
    * If the Coffee Machine was able to successfully make the
    * beverage it returns a Product instance that represents
    * the actual beverage. Otherwise, it returns null.
    */
    public Product brew(Beverage beverage);

    /**
    * Returns the Container of the Coffee Machine
    */
    public Container getSupplies();

    /**
    * Reffils the Container of the Coffee Machine with its default values
     * @throws OperationNotSupportedException 
    */
    public void refill() throws OperationNotSupportedException;
}