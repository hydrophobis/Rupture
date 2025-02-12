package main.java.com.content.entities;

import java.util.*;

import main.java.com.core.AnsiColors;
import main.java.com.core.Pair;
import main.java.com.content.Items;
import main.java.com.content.effects.DpsEffect;
import main.java.com.content.effects.Effect;
import main.java.com.content.items.Amulet;
import main.java.com.content.items.Item;
import main.java.com.content.items.Weapon;

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
    public List<Amulet> amulets = new ArrayList<>(3);
    public Weapon weapon = (Weapon) Items.basicSword;
 
    public  void update(){
        for(Effect effect : effects){
            effect.deal(this);
            if(effect.turns == 0){
                this.effects.remove(effect);
            }
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

    public String toString() {
        Map<Effect, Integer> effectCounts = new HashMap<>();

        for (Effect e : effects) {
            effectCounts.put(e, effectCounts.getOrDefault(e, 0) + 1);
        }
        List<Pair<Effect, Integer>> list = new ArrayList<>();
        for (Map.Entry<Effect, Integer> entry : effectCounts.entrySet()) {
            list.add(new Pair<>(entry.getKey(), entry.getValue()));
        }
        List<String> strings = new ArrayList<>();
        for(Pair<Effect, Integer> p : list){
            strings.add(p.two + "x " + p.one.toString());
        }
        return  this.name + 
                "\nHealth: " + AnsiColors.MAGENTA + health + AnsiColors.RESET + "/" + AnsiColors.MAGENTA + maxHealth + AnsiColors.RESET +
                "\nDamage: " + AnsiColors.RED + baseDamage + damage + AnsiColors.RESET + " (" + this.weapon.name + ")" +
                "\nAmulets: " + this.amulets +
                "\nEffects: " +  strings +
                "\nInventory: " + this.inventory;
    }
}
