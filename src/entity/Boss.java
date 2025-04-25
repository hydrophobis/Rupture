package entity;

import java.util.Random;

public class Boss extends LivingEntity {
    
    public int damageNeeded;

    public Boss(String name, int number, long seed){
        super(name);
        Random r = new Random(seed);
        damageNeeded = (int)(((double)r.nextInt(10) / 100.0d) * number * 0.35);

        System.out.println(damageNeeded);
    }
}
