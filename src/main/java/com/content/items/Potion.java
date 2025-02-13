package com.content.items;

import java.util.List;

import com.core.Pair;
import com.content.effects.Effect;
import com.content.entities.Entity;

public class Potion extends Item{
    List<Pair<Effect, Boolean>> effectPool;

    public Potion(String name, String lore, List<Pair<Effect, Boolean>> effectPool){
        super(name, lore);
        this.effectPool = effectPool;
    }

    public void consume(Entity entity){
        entity.effects.addAll(Effect.columnOne(effectPool));
        entity.inventory.remove(this);
    }
}
