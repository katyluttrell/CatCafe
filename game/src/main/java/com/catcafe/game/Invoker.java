package com.catcafe.game;
import java.util.ArrayList;
/**
 * COMMAND Pattern
 */
public class Invoker {
    ArrayList<Command> commandQueue;
    public Invoker(){
        commandQueue = new ArrayList<>();
    }
    void doNextCommand(){
        Command currentCommand = commandQueue.get(0);
        currentCommand.execute();
        System.out.println("executing "+currentCommand.getDescription());
        commandQueue.remove(0);
    }
    void addCommand(Command command){
        System.out.println("adding "+command.getDescription()+ " to command queue");
        commandQueue.add(command);
    }
    void doNow(Command command){}
}