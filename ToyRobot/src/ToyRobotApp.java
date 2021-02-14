package ToyRobot.src;

import ToyRobot.src.Commands.ICommand;
import ToyRobot.src.Executor.RobotExecutor;
import ToyRobot.src.Executor.Table;
import ToyRobot.src.Invoker.Invoker;

import java.util.List;
import java.util.logging.Logger;

public class ToyRobotApp {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Table table = new Table();
        RobotExecutor robotExecutor = new RobotExecutor(table);

        // Read the commands from a file
        CommandParser commandParser = new CommandParser();
        List<List<String>> rawCommands = commandParser.readFromFile("ToyRobot/data/testData");
        List<ICommand> commands = commandParser.convertToCommand(rawCommands);

        commands.forEach(command -> command.assignExecutor(robotExecutor));
        commands.forEach(command -> invoker.addCommand(command));
        invoker.startExecution();

    }
}
