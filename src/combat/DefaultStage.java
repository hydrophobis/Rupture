package combat;

public class DefaultStage extends Stage {
    
    public void init(){
        setHealth(stage * 150);
    }

    public DefaultStage(String name){
        super(name);
    }
}
