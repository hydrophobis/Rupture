package com;

import com.core.AnsiColors;
import com.core.Menu;
import com.core.menus.FightMenu;
import com.core.random.P59Shift;
import com.content.*;
import com.content.effects.DpsEffect;
import com.content.effects.Effect;
import com.content.entities.Entity;
import com.content.entities.Player;
import com.content.items.Amulet;
import com.content.items.Item;
import com.content.items.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static P59Shift random = new P59Shift();
    static Scanner scanner = new Scanner(System.in);

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        clearScreen();
        Effects.load();
        Items.load();
        Entities.load();


        Player player = new Player("Player", 10);
        player.damage = 0;

        boolean running = true;
        while (running) {
            Entity enemy = random.nextChoice(Entities.entityList);
            enemy.weapon = (Weapon)Items.basicSword;
            player.inventory.add(Items.dagger);
            player.inventory.add(Items.basicSword);
            player.inventory.add(Items.apple);
            player.effects.add(Effects.healthBoost);
            peacefulMenu(player);
            player.update();

            System.out.println("Entity " + fight(player, enemy) + " wins");
            Entities.load();
            //running = false;
        }
    }

    public static int fight(Player e1, Entity e2) throws IOException {
        if(e2.health < 1){
            return 2;
        }
        System.out.println(e2);
        new Menu().menu(new String[] { "Continue" }, "Enemy:\n" + e2.toString());
        while (e1.health > 0 && e2.health > 0) {
            clearScreen();
            e1.update();
            e2.update();

            int input = FightMenu.menu(e2.toString() + "\n\n" + e1.toString()) + 1;

            fightAction(input, e1, e2);
            attack(e2, e1);
            System.out.println(e2);
            if (e1.health <= 0) {
                return 1;
            } else if(e2.health <= 0){
                return 2;
            }

        }
        return 0;
    }

    public static void attack(Entity e1, Entity e2) {
        e2.health -= e1.damage;
        e2.effects.addAll(e1.weapon.dealtEffects);
    }

    public static void fightAction(int input, Player e1, Entity e2) throws IOException {
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
                for (int i = 0; i < e1.inventory.size(); i++) {
                    System.out.println(e1.inventory.get(i));
                    itemList.add(e1.inventory.get(i));
                    strarr[i] = e1.inventory.get(i).toString();
                }
                int input2 = new Menu().menu(strarr, e1.toString());
                itemList.get(input2).consume(e1);
                System.out.println(e1);
            }
            default:
                System.out.println("Bad input");
                break;
        }
    }

    public static int peacefulMenu(Entity e1){
        int input = new Menu().menu(new String[] { "Use an item", "Continue" }, e1.toString());
        switch (input) {
            case 0: {
                System.out.println("Select item to consume");
                List<Item> itemList = new ArrayList<>();
                String[] strarr = new String[e1.inventory.size()];
                for (int i = 0; i < e1.inventory.size(); i++) {
                    System.out.println(e1.inventory.get(i));
                    itemList.add(e1.inventory.get(i));
                    strarr[i] = e1.inventory.get(i).toString();
                }
                int input2 = new Menu().menu(strarr, e1.toString());
                itemList.get(input2).consume(e1);
                System.out.println(e1);  
                return 0;
            }
            case 1: {
                return 1;
            }
            default:
                return -1;
        }

    }
}