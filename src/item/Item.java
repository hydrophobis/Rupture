package item;

import entity.*;

public class Item {
    public String name;

    public void use(LivingEntity entity){
        System.out.println("Un-overridden Item.use() method called");
    }

    public Item(String name){
        this.name = name;
    }
}
