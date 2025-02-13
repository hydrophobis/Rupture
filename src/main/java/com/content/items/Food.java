package com.content.items;

import com.content.entities.Entity;

public class Food extends Item{
    public int healAmount;

    public void consume(Entity entity){
        entity.health += healAmount;
        if(entity.health > entity.maxHealth){
            entity.health = entity.maxHealth;
        }
        entity.inventory.remove(this);
    }

    public Food(String name, String lore, int heal){
        super(name, lore);
        this.healAmount = heal;
    }

    public Food(String name, int heal){
        this(name, "", heal);
    }
}
