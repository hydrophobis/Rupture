package content.items;

import java.util.List;

import content.effects.Effect;
import content.entities.Entity;

public class Weapon extends Item {
    public int damage;
    public List<Effect> dealtEffects;

    public Weapon(String name, String lore, int damage){
        super(name, lore);
        this.damage = damage;
    }

    public Weapon(String name, String lore, int damage, List<Effect> dealtEffects){
        this(name, lore, damage);
        this.dealtEffects.addAll(dealtEffects);
    }

    public void deal(Entity entity){
        entity.health -= this.damage;
        entity.effects.addAll(this.dealtEffects);
    }

    public void attack(Entity attacker, Entity defender){
        // TODO Implement this
    }

    public void consume(Entity entity){};
}
