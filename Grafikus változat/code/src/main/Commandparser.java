package main;
import subjects.*;
import java.util.Arrays;
import java.util.HashMap;

public class Commandparser {
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public Commandparser() {
        commands.put("exit", (args) -> System.exit(0));
        commands.put("toggleRandom", (args) -> Game.toggleRandom());
        commands.put("startGame", (args) -> Game.Start());
        commands.put("createField", Game.getMap()::createField);
        commands.put("createLaboratory", Game.getMap()::createLaboratory);
        commands.put("createWarehouse", Game.getMap()::createWarehouse);
        commands.put("createShelter", Game.getMap()::createShelter);
        commands.put("setNeighbor", Game.getMap()::setNeighbor);
        commands.put("lootField", (args) -> Game.getVirologist(args[0]).loot());
        commands.put("fieldInfo", (args) -> System.out.println(Game.getMap().getField(args[0]))); 
        commands.put("createVirologist", Game::createVirologist);
        commands.put("move", (args) -> Game.getVirologist(args[0]).move(Game.getMap().getField(args[1])));
        commands.put("virologistInfo", (args) -> System.out.println(Game.getVirologist(args[0])));
        commands.put("gameInfo", (args) -> Game.gameInfo()); 
        commands.put("produceAgent", (args) -> Game.getVirologist(args[0]).produceAgent(args));
        commands.put("startTimer", Game::startTimer);
        commands.put("stopTimer", Game::stopTimer);
        commands.put("infect", (args) -> Game.getVirologist(args[0]).infect(Game.getVirologist(args[1]), args[2]));
        commands.put("useAxe", (args) -> Game.getVirologist(args[0]).useAxe(Game.getVirologist(args[1])));
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
            System.out.println("EXECUTED: " + commandName);
        } 
        catch(NullPointerException e) {
            System.out.println("RUNTIME ERROR: command does not exist");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("SYNTAX ERROR: not enough parameters");
        } 
        catch (IncorrectParameterException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
