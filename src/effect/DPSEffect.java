package effect;

import entity.LivingEntity;

public class DPSEffect extends Effect {
    public int dps;

    @Override
    public void apply(LivingEntity entity){
        entity.setHealth(entity.getHealth() - dps);
    }

    public DPSEffect(String name){
        super(name);
    }
}
