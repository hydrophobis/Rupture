package entity;

import attribute.*;
import effect.Effect;

public class LivingEntity extends Entity {
    public Effect[] effects = new Effect[255];

    public void damage(int damage){
        this.setValue("health", this.getHealth() - damage);
    }

    public LivingEntity(String name){
        super(name);
    }

    public double getHealth(){
        return ((Attribute<Double>)this.getAttribute("health")).get();
    }

    public void setHealth(double h){
        this.setValue("health", h);
    }

}
