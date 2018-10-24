package bg.fmi.mjt.lab.coffee_machine;

import java.util.ArrayList;

public class Product {
    private ArrayList<String> luck = new ArrayList<String>() {{
         add("If at first you don't succeed call it version 1.0.");
         add("Today you will make magic happen!");
         add("Have you tried turning it off and on again?");
         add("Life would be much more easier if you had the source code.");}};

    public Product() {
        // TODO Auto-generated constructor stub
    }
    public String getName(){
        return null;}
    
    public int getQuantity(){
        return 0;}
    
    public String getLuck(){
        int i = 0 ;
        for (;;){
            this.luck.get(i);
            i++;
            if (i == this.luck.size()) { 
                i = 0;
            }
        }
   }
    
    public void setLuck(){
        
    }
}
