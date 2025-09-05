package rupture.entity;

import rupture.content.Attributes;

public class Stage extends Entity {

    public void takeDamage(float value){
        attributes.get(Attributes.health).addModifier(x -> x - value);
    }

    public Stage(String name) {
        super(name);
    }
    
}
