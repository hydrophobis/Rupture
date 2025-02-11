package content.effects;

import content.entities.Entity;

public class DpsEffect extends Effect{
    public int dps;

    public DpsEffect(String name, int turns, int dps){
        super(name, turns);
        this.dps = dps;
    }

    public void deal(Entity entity){
        if(entity.health - dps < entity.maxHealth && entity.health - dps > 0){
            entity.health -= dps;
        } else if(entity.health - dps < 0){
            entity.health = 0;
        }
        turns--;
        if(turns == 0){
            entity.effects.remove(this);
        }
    }
}
