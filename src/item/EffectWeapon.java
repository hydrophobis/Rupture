package item;

import java.util.Arrays;
import java.util.Collections;

import attribute.*;
import effect.*;
import entity.*;

public class EffectWeapon extends Weapon {
    public Effect[] effects;

    public void use(LivingEntity entity){
        int i = firstNull(entity.effects);
        for(Effect e : effects){
            entity.effects[i] = e;
        }
    }

    public EffectWeapon(String name){
        super(name);
    }

    public <T> int firstNull(T[] a){
        int i = 0;
        for(T t : a){
            if(a[i] == null){
                return i;
            }
            i += 1;
        }
        return -1;
    }
}
