package main.java.com.content.entities;

import java.util.ArrayList;
import java.util.List;

import main.java.com.content.*;
import main.java.com.content.effects.Effect;
import main.java.com.content.items.*;

public class Player extends Entity {
    public static final int baseHealth = 10;
    public static final int baseDamage = 1;
    Item armor;
    

    public void update(){
        this.damage = this.weapon.damage;
        
        for(int i = 0; i < this.effects.size(); i++){
            this.effects.get(i).deal(this);
        }
        for(int i = 0; i < this.amulets.size(); i++){
            this.amulets.get(i).consume(this);
        }
    }

    public Player(String name, int maxHealth){
        super(name, Player.baseDamage, maxHealth);
    }
}
