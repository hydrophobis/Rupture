package entity;

import java.util.*;
import java.util.Map;

import attribute.*;
import item.*;

public class Player extends LivingEntity {

    public Weapon weapon;

    public Player(String name) {
        super(name);
    }

    
    public String toString() {
        return String.format("[HP: %s ⚔: %s]", getValue("health"), getValue("damage"));
    }
}
