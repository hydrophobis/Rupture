package com.content.entities;

import java.util.*;
import java.util.stream.Collectors;

import com.core.AnsiColors;
import com.core.Pair;
import com.content.Items;
import com.content.effects.DpsEffect;
import com.content.effects.Effect;
import com.content.items.Amulet;
import com.content.items.Item;
import com.content.items.Weapon;

public class Entity {
    public int health = 0;
    public String name;
    public List<Effect> effects =  new ArrayList<>();
    public List<Effect> immunities = new ArrayList<>();
    public int maxHealth = 0;
    public int damage = 0;
    public double dexterity;
    public static final int baseHealth = 0;
    public static final int baseDamage = 0;
    public List<Item> inventory =  new ArrayList<>();
    public List<Amulet> amulets = new ArrayList<>(3);
    public Weapon weapon = (Weapon) Items.basicSword;
    public boolean passive = false;
 
    public  void update(){
        for(Effect effect : effects){
            effect.deal(this);
            if(effect.turns == 0){
                this.effects.remove(effect);
            }
        }
        uniqueInvItems();
    }

    public void uniqueInvItems(){
        this.inventory = this.inventory.stream().distinct().collect(Collectors.toList());
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
            if(e != null){
                effectCounts.put(e, effectCounts.getOrDefault(e, 0) + 1);
            }
            
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
                "\nEffects: " + strings +
                "\nWeapon: " + this.weapon + 
                "\nInventory: " + this.inventory;
    }
}
