package rupture.content;

import rupture.entity.*;

public class Entities extends bogus.core.Loader {

    public static Entity player,
    
    basicStage
    ;

    @Override
    public void load() {
        player = new Player("player"){{
            attributes.set(Attributes.health, 10f);
        }};

        basicStage = new Stage("basic"){{
            attributes.set(Attributes.health, 5f);
        }};
    }
    
}
