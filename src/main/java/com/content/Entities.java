package com.content;
import java.util.ArrayList;
import java.util.List;

import com.content.entities.Entity;

public class Entities {

    public static List<Entity> entityList = new ArrayList<>();

    public static Entity

    goblin,
    
    sheep;

    public static void load(){
        goblin = new Entity("Goblin", 2, 4);

        sheep = new Entity("Sheep", 1, 4);
        sheep.passive = true;

        updateEntityList(goblin, sheep);
    }
        
    public static void updateEntityList(Entity... entities){
        for(Entity e : entities){
            entityList.add(e);
        }
    }
}
