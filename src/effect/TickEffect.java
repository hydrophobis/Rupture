package effect;

public class TickEffect extends Effect {
    
    public void tick(){
        System.out.println("Un-overridden TickEffect.tick() function called");
    }

    public TickEffect(String name){
        super(name);
    }
}
