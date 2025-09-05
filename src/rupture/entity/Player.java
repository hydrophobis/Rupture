package rupture.entity;

import rupture.content.Tags;

public class Player extends CarryingEntity {

    public Player(String name) {
        super(name);
        tags.add(Tags.player);
        tags.add(Tags.living);
    }
}
