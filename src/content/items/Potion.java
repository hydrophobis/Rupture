package content.items;

import java.util.List;

import content.effects.Effect;
import content.entities.Entity;

public class Potion extends Item{
    List<Effect> effectPool;

    public Potion(String name, String lore, List<Effect> effectPool){
        super(name, lore);
        this.effectPool = effectPool;
    }

    public void consume(Entity entity){
        entity.effects.addAll(effectPool);
        entity.inventory.remove(this);
    }
}
