package entity;

import attribute.*;

public class LivingEntity extends Entity {
    public Attribute<Integer> health;
    public Attribute<Integer> damage;

    public LivingEntity(String name){
        super(name);
    }
}
