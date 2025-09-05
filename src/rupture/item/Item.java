package rupture.item;

import rupture.attribute.*;
import rupture.tag.*;

public class Item extends Taggable {
    String name;
    String lore;
    AttributeContainer attributes;

    public Item(String name){
        this.name = name;
    }
}
