package content;

import entity.*;
import attribute.*;
import effect.DPSEffect;
import effect.Effect;

public class Effects extends ContentLoader {
    public static Effect 
    bleed, rupture // !!!! NO WAY !!!!
    ;

    public static void load(){
        bleed = new DPSEffect("bleed"){{
            dps = 2;
        }};

        rupture = new DPSEffect("rupture"){{
            dps = 4;
        }};
    }
}
