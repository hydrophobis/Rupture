package content;

import attribute.Attribute;
import entity.Entity;
import entity.Player;

public class Entities extends ContentLoader {
    public static Entity 
    player,
    
    goblin;

    public static void load(){
        player = new Player("player"){{
            health = Attribute.intAttribute(100);
            damage = Attribute.intAttribute(5);
        }};
    }
}
