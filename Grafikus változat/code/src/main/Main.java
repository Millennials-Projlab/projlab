package main;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Commandparser cp = new Commandparser();
        try (Scanner scanner = new Scanner(System.in)) {
            while(true) {
                String cmd = scanner.nextLine();
                
                cp.parse(cmd); // parse command from standard input
            }
        }
    }
}
