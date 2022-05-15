package main;

public interface Command {
    void execute(String[] args) throws IncorrectParameterException;
}