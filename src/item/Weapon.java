package item;

import entity.LivingEntity;

public class Weapon extends Item {
    public int damage;

    public void use(LivingEntity entity){
        entity.setHealth(entity.getHealth() - damage);
    }

    public Weapon(String name){
        super(name);
    }
}
