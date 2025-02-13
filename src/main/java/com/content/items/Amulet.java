package com.content.items;

import com.core.Pair;
import com.content.*;
import com.content.effects.*;
import com.content.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class Amulet extends Item {
    public Amulet(String name, String lore) {
        super(name, lore);
    }
    
    
        List<Pair<Effect, Boolean>> effectPool = new ArrayList<>(); // Boolean is whether or not it stacks


    public void consume(Entity entity){
        for(Pair<Effect, Boolean> e : effectPool){
            if(!e.two){
                if(!entity.effects.contains(e.one)){
                    entity.effects.add(e.one);
                }
            } else {
                entity.effects.add(e.one);
            }
        }
    }
}
