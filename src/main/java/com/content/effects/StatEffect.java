package com.content.effects;

import java.lang.reflect.Field;

import com.content.entities.Entity;

public class StatEffect extends Effect {

    public String stat;
    public int increase;
    public int previous;

    public void deal(Entity entity){
        setStat(stat, entity, getStat(name, entity) + increase);
        turns--;
        if(turns == 0){
            setStat(stat, entity, previous);
        }
    }

    public void setStat(String name, Entity entity, int amount){
        try {
            Field field = Entity.class.getDeclaredField(name);
            field.setAccessible(true);
            this.previous = getStat(name, entity);
            field.set(entity, 10);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public int getStat(String name, Entity entity){
        try {
            Field field = Entity.class.getDeclaredField(name);
            field.setAccessible(true);
            return field.getInt(field);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public StatEffect(String name, int turns, String color, String stat, int increase){
        super(name, turns, color);
        this.stat = stat;
        this.increase = increase;
    }
}
