package content;

import attribute.Attribute;
import combat.DefaultStage;
import entity.Entity;
import entity.Player;

public class Entities extends ContentLoader {
    public static Entity player,
    
    defaultStage, smallStage, bigStage, hugeStage;

    public static void load(){
        player = new Player("player"){{
            this.setAttribute("turns", Attribute.turns(3));
        }};

        defaultStage = new DefaultStage("default"){{
            this.stage = -1;
            this.init();
        }};
    }
}
