package content;

import entity.*;
import attribute.*;
import effect.Effect;
import effect.TickEffect;

public class Effects extends ContentLoader {
    public static Effect 
    bleed, rupture // !!!! NO WAY !!!!
    ;

    public static void load(){
        bleed = new TickEffect<Integer>("bleed"){
            {
                tick_attribute = Attribute.intAttribute(2);
            }

            @Override
            public void tick(LivingEntity entity){
                entity.health.value -= tick_attribute.value;
            }
        };

        rupture = new TickEffect<Integer>("rupture"){
            {
                tick_attribute = Attribute.intAttribute(5);
            }
        };
    }
}
