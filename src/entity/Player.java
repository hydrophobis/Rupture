package entity;

import attribute.Attribute;

public class Player extends LivingEntity {

    public Attribute<Integer> damage;

    public Player(String name){
        super(name);
    }

    public String toString(){
        return String.format("[%S❤][%S⚔]\n", health, damage);
    }
}
