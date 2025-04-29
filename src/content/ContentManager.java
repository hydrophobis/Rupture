package content;

public class ContentManager extends ContentLoader {
    public static void load(){
        Effects.load();
        Entities.load();
        Items.load();
    }
}
