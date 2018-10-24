package bg.fmi.mjt.lab.coffee_machine.container;

public class BasicContainer extends Container {
    
    private static final double BASIC_CONTAINER_INITIAL_WATER = 600;
    private static final double BASIC_CONTAINER_INITIAL_COFFEE = 600;
    double water;
    double coffee;
    
    public BasicContainer() {

        
    }
    public BasicContainer(double wat, double cof){
        this.water = BASIC_CONTAINER_INITIAL_WATER - wat;
        this.coffee = BASIC_CONTAINER_INITIAL_COFFEE - cof;
    }

    @Override
    public double getCurrentWater() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getCurrentMilk() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getCurrentCoffee() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getCurrentCacao() {
        // TODO Auto-generated method stub
        return 0;
    }

}
