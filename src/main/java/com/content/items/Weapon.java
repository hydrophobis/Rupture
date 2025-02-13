package com.content.items;

import java.util.ArrayList;
import java.util.List;

import com.content.effects.Effect;
import com.content.entities.Entity;
import com.content.items.*;

public class Weapon extends Item {
    public int damage;
    public List<Effect> dealtEffects = new ArrayList<>();

    public Weapon(String name, String lore, int damage){
        super(name, lore);
        this.damage = damage;
    }

    public Weapon(String name, String lore, int damage, List<Effect> dealtEffects){
        this(name, lore, damage);
        this.dealtEffects.addAll(dealtEffects);
    }

    public void deal(Entity entity){
        entity.health -= this.damage;
        entity.effects.addAll(this.dealtEffects);
    }

    public void consume(Entity entity){
        entity.weapon = this;
        entity.inventory.remove(this);
    };
}
