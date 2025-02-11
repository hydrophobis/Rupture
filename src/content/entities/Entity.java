package content.entities;

import java.util.List;

import content.effects.Effect;

public class Entity {
    public int health;
    public String name;
    public List<Effect> effects;
    public int maxHealth = 0;
    public int damage = 0;
    public static final int baseHealth = 0;
    public static final int baseDamage = 0;

    public Entity(String name, int damage, int maxHealth){
        this.name = name;
        this.maxHealth = maxHealth;
        this.damage = damage;
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
