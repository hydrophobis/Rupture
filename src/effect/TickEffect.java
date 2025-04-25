package effect;

import attribute.*;

import entity.LivingEntity;

public class TickEffect<T> extends Effect {
    public Attribute<T> tick_attribute;
    
    public void tick(LivingEntity entity){
        System.out.println("Un-overridden TickEffect.tick() function called");
    }

    public TickEffect(String name){
        super(name);
    }
}
