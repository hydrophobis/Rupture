package rupture.entity;

import rupture.attribute.*;
import rupture.tag.*;

public class Entity extends Taggable {
    public String name;
    public AttributeContainer attributes;

    public Entity(String name){
        this.name = name;
    }
}
