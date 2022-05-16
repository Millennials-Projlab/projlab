package main;

import UI.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /* PROTO
        Commandparser cp = new Commandparser();
        try (Scanner scanner = new Scanner(System.in)) {
            while(true) {
                String cmd = scanner.nextLine();
                
                cp.parse(cmd); // parse command from standard input
            }
        }
        */

        MainFrame mainframe = new MainFrame();
        mainframe.initialize();
    }
}
