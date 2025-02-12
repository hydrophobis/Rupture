package main.java.com.content;
import main.java.com.core.AnsiColors;
import main.java.com.content.effects.*;
import main.java.com.content.entities.Entity;

public class Effects {
    public static Effect 
    
    rupture, poison, bleed,
    
    strength,
    
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


        strength = new StatEffect("Strength", 5, "damage", AnsiColors.YELLOW,3);
        
        regeneration = new DpsEffect("Regeneration", 5, AnsiColors.MAGENTA, 2);
        healthGain = new DpsEffect("Health Gain", 1, AnsiColors.BRIGHT_MAGENTA, 10);
    }
}
