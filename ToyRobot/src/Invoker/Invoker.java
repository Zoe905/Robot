package ToyRobot.src.Invoker;

import ToyRobot.src.Commands.ICommand;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<ICommand> commands;

    public Invoker() {
        commands = new ArrayList<>();
    }

    public void addCommand(ICommand newCommand) {
        commands.add(newCommand);
    }
    public void startExecution() {
        commands.forEach(command -> command.execute());
    }
}
