package effect;

import entity.LivingEntity;

public class EffectStack {
    public int amount;
    public Effect effect;

    public void apply(LivingEntity e){
        for(int i = 0; i < amount; i++){
            effect.apply(e);
        }
    }

    public EffectStack(Effect e, int amount){
        this.effect = e;
        this.amount = amount;
    }
}
