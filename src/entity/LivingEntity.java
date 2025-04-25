package entity;

import attribute.*;
import effect.Effect;

public class LivingEntity extends Entity {
    public Attribute<Integer> health;
    public Effect[] effects = new Effect[255];

    public void damage(int damage){
        health.value -= damage;
    }

    public LivingEntity(String name){
        super(name);
    }
}
