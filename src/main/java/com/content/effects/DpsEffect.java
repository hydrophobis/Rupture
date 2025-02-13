package com.content.effects;

import com.content.entities.Entity;

public class DpsEffect extends Effect{
    public int dps;

    public DpsEffect(String name, int turns, String color, int dps){
        super(name, turns, color);
        this.dps = dps;
    }

    public void deal(Entity entity){
        if(entity.health - dps < entity.maxHealth && entity.health - dps > 0){
            entity.health -= dps;
        } else if(entity.health - dps < 0){
            entity.health = 0;
        }
        turns--;
        if(turns == 0){
            entity.effects.remove(this);
        }
    }
}
