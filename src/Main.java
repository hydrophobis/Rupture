import content.Effects;
import content.Entities;
import content.Items;
import content.effects.DpsEffect;
import content.effects.Effect;
import content.entities.Entity;
import content.entities.Player;
import content.*;

public class Main {

    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void main(String[] args) {
        clearScreen();
        Items.load();
        Entities.load();
        Effects.load();

        Player player = new Player("Player", 10);
        player.damage = 0;


        boolean running = true;
        while(running){
            Entity enemy = Entities.goblin;

            player.inventory.add(Items.basicSword);
            player.effects.add(Effects.poison);

            System.out.println(player + "\nInventory: " + player.inventory.toString());
            player.update();

            running = false;            
        }
    }
}