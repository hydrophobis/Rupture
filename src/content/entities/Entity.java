package content.entities;

import java.util.ArrayList;
import java.util.List;

import content.effects.DpsEffect;
import content.effects.Effect;
import content.items.Item;

public class Entity {
    public int health = 0;
    public String name;
    public List<Effect> effects =  new ArrayList<>();
    public List<Effect> immunities = new ArrayList<>();
    public int maxHealth = 0;
    public int damage = 0;
    public static final int baseHealth = 0;
    public static final int baseDamage = 0;
    public List<Item> inventory =  new ArrayList<>();

    public void update(){
        for(Effect effect : effects){
            effect.deal(this);
        }
    }

    public Entity(String name, int damage, int maxHealth){
        this.name = name;
        this.maxHealth = maxHealth;
        this.damage = damage;
        this.health = maxHealth;
    }

    public Entity(String name, int damage, int maxHealth, int health){
        this(name, maxHealth, damage);
        this.health = health;
    }

    public Entity(String name, int damage, int maxHealth, int health, List<Effect> effects){
        this(name, damage, maxHealth);
        this.health = health;
        this.effects = effects;
    }

    public Entity(String name, int damage, int maxHealth, List<Effect> effects){
        this(name, damage, maxHealth, maxHealth);
        this.effects = effects;
    }
}
