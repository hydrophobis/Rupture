package effect;

import entity.LivingEntity;

public class Effect {
    public String name;

    public void apply(LivingEntity e){
        return;
    }

    public Effect(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
