package rupture.entity;

import rupture.content.Tags;
import rupture.item.Inventory;

public class CarryingEntity extends Entity {

    Inventory inventory;

    public CarryingEntity(String name) {
        super(name);
        tags.add(Tags.carries);
    }
    
}
