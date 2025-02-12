package main.java.com.core.menus;

import java.io.IOException;

import main.java.com.core.Menu;

public class FightMenu extends Menu {
    public final static String[] options = {"Attack", "Use an item"};

    public static int menu(String header) throws IOException {
        return Menu.menu(options, header);
    }
}
