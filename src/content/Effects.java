package content;
import content.effects.*;
import content.entities.Entity;

public class Effects {
    public static Effect 
    
    rupture, poison, bleed,
    
    strength,
    
    regeneration, healthGain;

    public static void load(){
        rupture = new DpsEffect("Rupture", 3, 7);
        poison = new DpsEffect("Poison", 3, 1){
            public void deal(Entity entity){
                super.deal(entity);
                this.dps += 1;
            }
        };
        bleed = new DpsEffect("Bleed", 10, 1);


        strength = new StatEffect("Strength", 5, "damage", 3);
        
        regeneration = new DpsEffect("Regeneration", 5, 2);
        healthGain = new DpsEffect("Health Gain", 1, 10);
    }
}
