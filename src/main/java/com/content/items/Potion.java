package main.java.com.content.items;

import java.util.List;

import main.java.com.core.Pair;
import main.java.com.content.effects.Effect;
import main.java.com.content.entities.Entity;

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
