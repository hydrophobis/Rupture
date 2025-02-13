package com.core.menus;

import java.io.IOException;

import com.core.Menu;

public class FightMenu extends Menu {
    public final static String[] options = {"Attack", "Use an item"};

    public static int menu(String header) throws IOException {
        return new Menu().menu(options, header);
    }
}
