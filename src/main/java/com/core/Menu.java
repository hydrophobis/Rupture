package main.java.com.core;

import org.jline.terminal.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Menu {
        private static int currentSelection = 0;
    
        public static int menu(String[] options, String header) throws IOException {
            List<String> option = Arrays.asList(options);
            try (Terminal terminal = TerminalBuilder.terminal()) {
                terminal.enterRawMode();
                int input;

                while (true) {
                    System.out.println(header);
                    printMenu(option);

                    input = terminal.reader().read();

                    if (input == 's') {
                        currentSelection = Math.min(currentSelection + 1, option.size() - 1);
                    } else if (input == 'w') {
                        currentSelection = Math.max(currentSelection - 1, 0);
                    } else if (input == 'd') {
                        System.out.println("Selected: " + option.get(currentSelection));
                        return currentSelection;
                    }
                    clearConsole();
                }
            }
    }

    private static void printMenu(List<String> options) {
        System.out.println("Use 'w' for up, 's' for down. Press d to select:");
        for (int i = 0; i < options.size(); i++) {
            if (i == currentSelection) {
                System.out.println("> " + options.get(i));
            } else {
                System.out.println("  " + options.get(i));
            }
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
