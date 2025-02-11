package content.effects;

import content.entities.Entity;

public abstract class Effect {
    public String name;
    public int turns;

    public Effect(String name, int turns){
        this.name = name;
        this.turns = turns;
    }

    public abstract void deal(Entity entity);
}