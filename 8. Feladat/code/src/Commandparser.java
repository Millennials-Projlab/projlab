import java.util.Arrays;
import java.util.HashMap;

public class Commandparser {
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public Commandparser() {
        commands.put("exit", (args) -> System.exit(0));
    }

    public void parse(String command) {
        String[] splitted = command.split(" ");

        String commandName = splitted[0];
        String[] parameters = Arrays.copyOfRange(splitted, 1, splitted.length);
    
        execute(commandName, parameters);

    }

    private void execute(String commandName, String[] parameters) {
        try {
            commands.get(commandName).execute(parameters);
        } catch(NullPointerException ex) {
            System.out.println("RUNTIME ERROR: command does not exist");
        }
    }
}
