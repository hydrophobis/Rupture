package content;
import content.items.*;

import java.util.ArrayList;

import content.*;

public class Items {
    public static Item 

    basicSword, apple, dagger;

    public static void load(){
        basicSword = new Weapon("Basic Sword", "Just a normal iron sword", 2);
        dagger = new Weapon("Dagger", "Pointy stabby thing", 2){{
            this.dealtEffects.add(Effects.bleed);
        }};

        apple = new Food("Apple", 4);
    }
}
