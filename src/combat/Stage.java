package combat;

import entity.*;

public abstract class Stage extends LivingEntity {
    public int stage;

    String name;
    
    public Stage(String name){
        super(name);
    }

    public abstract void init();
}
