package item;

import entity.LivingEntity;

public class Weapon extends Item {
    public int damage;

    public void use(LivingEntity entity){
        entity.health.value -= damage;
    }

    public Weapon(String name){
        super(name);
    }
}
