package rupture.content;

import rupture.attribute.*;

public class Attributes extends bogus.core.Loader {

    public static AttributeKey<Float> health, damage;

    @Override
    public void load() {
        health = new AttributeKey<Float>("health", 10f);
    }
    
}
