package content;

import item.*;
import content.*;
import effect.Effect;

public class Items extends ContentLoader {
    public static Item sword, dagger;

    public static void load(){
        sword = new Weapon("sword"){{
            damage = 4;
        }};

        dagger = new EffectWeapon("dagger"){{
            effects = new Effect[]{ Effects.bleed }; 
        }};
    }
}
