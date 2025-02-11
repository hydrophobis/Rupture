package content.items;

public class Weapon extends Item {
    int damage;

    public Weapon(String name, String lore, int damage){
        super(name, lore);
        this.damage = damage;
    }
}
