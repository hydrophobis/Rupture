package content.entities;

public class Player extends Entity {
    public static final int baseHealth = 10;
    public static final int baseDamage = 1;

    public Player(String name, int maxHealth){
        super(name, Player.baseDamage, maxHealth);
    }
}
