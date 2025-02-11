package content.entities;

import java.util.ArrayList;
import java.util.List;

import content.Items;
import content.effects.Effect;
import content.items.*;
import content.*;

public class Player extends Entity {
    public static final int baseHealth = 10;
    public static final int baseDamage = 1;
    Item armor;
    Weapon weapon = (Weapon) Items.basicSword;

    public void update(){
        this.damage = this.weapon.damage;
        
        for(Effect effect : effects){
            effect.deal(this);
        }
    }

    public Player(String name, int maxHealth){
        super(name, Player.baseDamage, maxHealth);
    }

    public String toString(){
        return this.name + "\n" + "Health: " + AnsiColors.MAGENTA + health + AnsiColors.RESET + "/" + AnsiColors.MAGENTA + maxHealth + AnsiColors.RESET + "\nDamage: " + AnsiColors.RED + baseDamage + damage +  AnsiColors.RESET;
    }
}
