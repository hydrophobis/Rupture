package effect;

public class Effects {
    public static Effect bleed;

    public static void load(){
        bleed = new TickEffect("bleed"){{
            public void tick(){
                return;
            }
        }};
    }
}
