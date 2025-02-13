package com.core;

import java.io.IOException;
import java.util.List;

import org.jline.keymap.KeyMap;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

public class Menu {
    private Terminal terminal;
    private LineReader lineReader;
    private int selectedIndex = 0;

    public Menu() {
        try {
            terminal = TerminalBuilder.builder().system(true).build();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        lineReader = LineReaderBuilder.builder().terminal(terminal).build();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int menu(String[] options, String header) {
        while (true) {
            renderMenu(options, header);
            char input = readKey();

            switch (input) {
                case 'A': // Up arrow
                    if (selectedIndex > 0) {
                        selectedIndex--;
                    }
                    break;
                case 'B': // Down arrow
                    if (selectedIndex < options.length - 1) {
                        selectedIndex++;
                    }
                    break;
                case '\r': // Enter key
                    return selectedIndex;
            }
        }
    }

    private void renderMenu(String[] options, String header) {
        clearScreen();
        System.out.println(header);
        terminal.puts(InfoCmp.Capability.clear_screen);
        for (int i = 0; i < options.length; i++) {
            if (i == selectedIndex) {
                System.out.println(" > " + options[i]);
            } else {
                System.out.println("   " + options[i]);
            }
        }
    }

    private char readKey() {
        try {
            terminal.enterRawMode();
            int c1 = terminal.reader().read();
            if (c1 == 27) { // esc seq
                int c2 = terminal.reader().read();
                int c3 = terminal.reader().read();
                if (c2 == 91) {
                    return (char) c3; // a is up b is down
                }
            } else if (c1 == 13) { // Enter key
                return '\r';
            }
            return (char) c1;
        } catch (IOException e) {
            e.printStackTrace();
            return '\0';
        }
    }
}
