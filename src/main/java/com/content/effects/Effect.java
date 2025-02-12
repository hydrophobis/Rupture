package main.java.com.content.effects;

import java.util.ArrayList;
import java.util.List;

import main.java.com.core.AnsiColors;
import main.java.com.core.Pair;
import main.java.com.content.entities.Entity;

public abstract class Effect {
    public String name;
    public String color;
    public int turns;

    public Effect(String name, int turns, String color){
        this.name = name;
        this.turns = turns;
        this.color = color;
    }

    public abstract void deal(Entity entity);

    public static List<Effect> columnOne(List<Pair<Effect, Boolean>> l){
        List<Effect> out = new ArrayList<>();
        for(int i = 0; i < l.size(); i++){
            out.add(l.get(i).one);
        }
        return out;
    }

    public String toString(){
        return this.color + this.name + AnsiColors.RESET + " for " + this.color + this.turns + AnsiColors.RESET + " turns";
    }

    public boolean equals(Effect e){
        if(e.name == this.name){
            return true;
        }
        return false;    }
}