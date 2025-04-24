package entity;

import attribute.Attribute;

public class Entities {
    public static Entity 
    player,
    
    goblin;

    public static void load(){
        player = new Player("player"){{
            health = Attribute.intAttribute(100);
            damage = Attribute.intAttribute(5);
        }};

        goblin = new Enemy("goblin"){{
            health = Attribute.intAttribute(15);
            damage = Attribute.intAttribute(5);
        }};
    }
}
