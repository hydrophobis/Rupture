package com.content;
import java.util.ArrayList;

import com.content.*;
import com.content.effects.Effect;
import com.content.entities.Entity;
import com.content.items.*;

public class Items {
    public static Item 
    // AMULETS
    bleedAmulet,

    // WEAPONS
    basicSword, dagger,
    
    // CONSUMEABLES
    apple;

    public static void load(){
        // AMULETS
        bleedAmulet = new Amulet("Bleed Amulet", "Turns blood into life"){
            public void consume(Entity entity){
                int counter = 0;
                for(Effect e : entity.effects){
                    if(e == Effects.bleed){
                        counter++;
                    }
                }
                for(int i = 0; i < counter / 3; i++){
                    entity.effects.add(Effects.healthGain);
                }
            }
        };


        // WEAPONS
        basicSword = new Weapon("Basic Sword", "Just a normal iron sword", 2);
        dagger = new Weapon("Dagger", "Pointy stabby thing", 2){{
            this.dealtEffects.add(Effects.bleed);
        }};


        // CONSUMEABLES
        apple = new Food("Apple", 4);
    }
}
