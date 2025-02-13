package com.content;
import com.core.AnsiColors;
import com.content.effects.*;
import com.content.entities.Entity;

public class Effects {
    public static Effect 
    
    rupture, poison, bleed,
    
    strength, healthBoost,
    
    regeneration, healthGain;

    public static void load(){
        rupture = new DpsEffect("Rupture", 3, AnsiColors.BRIGHT_RED,7);
        poison = new DpsEffect("Poison", 3, AnsiColors.GREEN,1){
            public void deal(Entity entity){
                super.deal(entity);
                this.dps += 1;
            }
        };
        bleed = new DpsEffect("Bleed", 10, AnsiColors.RED, 1);


        strength = new StatEffect("Strength", 5, AnsiColors.YELLOW, "damage",3);
        healthBoost = new StatEffect("Health Boost", 50, AnsiColors.BRIGHT_MAGENTA, "maxHealth", 15);
        
        regeneration = new DpsEffect("Regeneration", 5, AnsiColors.MAGENTA, 2);
        healthGain = new DpsEffect("Health Gain", 1, AnsiColors.MAGENTA, 10);
    }
}
