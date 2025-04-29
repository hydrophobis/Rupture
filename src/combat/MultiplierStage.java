package combat;

import attribute.Attribute;

public class MultiplierStage extends Stage {
    
    public double multiplier;

    public void init(){
        this.setHealth(stage * multiplier);
    }

    public MultiplierStage(String name){
        super(name);
    }
}
