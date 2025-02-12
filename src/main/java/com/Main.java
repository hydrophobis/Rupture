package main.java.com;

import main.java.com.core.AnsiColors;
import main.java.com.core.Menu;
import main.java.com.core.menus.FightMenu;
import main.java.com.content.*;
import main.java.com.content.effects.DpsEffect;
import main.java.com.content.effects.Effect;
import main.java.com.content.entities.Entity;
import main.java.com.content.entities.Player;
import main.java.com.content.items.Amulet;
import main.java.com.content.items.Item;
import main.java.com.content.items.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static final String[] fightMenuOptions = {"Attack", "Consume Item", "Equip Item"};

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    public static void main(String[] args) throws InterruptedException, IOException{
        clearScreen();
        Items.load();
        Entities.load();
        Effects.load();

        Player player = new Player("Player", 10);
        player.damage = 0;


        boolean running = true;
        while(running){
            Entity enemy = Entities.goblin;

            player.inventory.add(Items.dagger);
            player.inventory.add(Items.basicSword);
            player.amulets.add((Amulet)Items.bleedAmulet);
            player.effects.add(Effects.bleed);
            player.effects.add(Effects.bleed);
            player.effects.add(Effects.bleed);
            player.update();
            fight(player, enemy);
            running = false;   
        }
    }

    public static int fight(Player e1, Entity e2) throws IOException{
        Menu.menu(new String[]{"Continue"}, e1.toString());
        while(e1.health > 0 && e2.health > 0){
            clearScreen();
            e1.update();
            e2.update();

            int input = FightMenu.menu(e2.toString() + "\n\n" + e1.toString()) + 1;

            fightAction(input, e1, e2);
            System.out.println(e2);
            if(e1.health <= 0){
                return 1;
            }
            return 2;
        }
        return 0;
    }

    public static void attack(Player e1, Entity e2){
        e2.health -= e1.damage;
        e2.effects.addAll(e1.weapon.dealtEffects);
    }

    public static void fightAction(int input, Player e1, Entity e2) throws IOException{
        clearScreen();
        switch (input) {
            case 1: {
                attack(e1, e2);
                break;
            }
            case 2: {
                System.out.println("Select item to consume");
                List<Item> itemList = new ArrayList<>();
                String[] strarr = new String[e1.inventory.size()];
                for(int i = 0; i < e1.inventory.size(); i++){
                    System.out.println(e1.inventory.get(i));
                    itemList.add(e1.inventory.get(i));
                    strarr[i] = e1.inventory.get(i).toString();
                }
                int input2 = Menu.menu(strarr, e1.toString());
                itemList.get(input2).consume(e1);
                System.out.println(e1);
            }
            default:
                System.out.println("Bad finger dexterity causes you to lose your turn");
                break;
        }
    }
}