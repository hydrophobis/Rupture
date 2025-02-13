package com.content.entities;

import java.util.stream.Collectors;

import com.core.Menu;

public class Player extends Entity {
    public static final int baseHealth = 10;
    public static final int baseDamage = 1;
    

    public void update(){
        this.damage = this.weapon.damage;
        
        for(int i = 0; i < this.effects.size(); i++){
            this.effects.get(i).deal(this);
        }
        for(int i = 0; i < this.amulets.size(); i++){
            this.amulets.get(i).consume(this);
        }
        uniqueInvItems();
    }

    public Player(String name, int maxHealth){
        super(name, Player.baseDamage, maxHealth);
    }
}
