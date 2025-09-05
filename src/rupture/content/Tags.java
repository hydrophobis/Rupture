package rupture.content;

import rupture.tag.*;

public class Tags extends bogus.core.Loader {

    public static Tag item, weapon, handheld, healing,
    
    player, living, carries,

    poisonImmune, bleedImmune
    ;

    @Override
    public void load() {
        item = new Tag("rupture:item");
        weapon = new Tag("rupture:weapon");
        handheld = new Tag("rupture:handheld");

        player = new Tag("rupture:player");
        living = new Tag("rupture:living");
        carries = new Tag("rupture:carries");

        poisonImmune = new Tag("rupture:poison-immune");
        bleedImmune = new Tag("rupture:bleed-immune");
    }
    
}
