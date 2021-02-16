package ToyRobot.src;

import ToyRobot.src.Commands.ICommand;
import ToyRobot.src.DataReader.CmdReader;
import ToyRobot.src.DataReader.FileReader;
import ToyRobot.src.DataReader.IReader;
import ToyRobot.src.Executor.RobotExecutor;
import ToyRobot.src.Executor.Table;

import java.io.FileNotFoundException;
import java.util.List;

public class ToyRobotApp {
    public static void main(String[] args) throws FileNotFoundException {
        Table table = new Table();
        RobotExecutor robotExecutor = new RobotExecutor(table);

        // Read the commands from a file
        IReader reader;
        switch (args[0]) {
            case "-f":
                reader = new FileReader(args[1]);
                break;
            case "-cmd":
            default:
                reader = new CmdReader();
                break;
        }
        CommandParser commandParser = new CommandParser();
        CommandGenerator commandGenerator = new CommandGenerator();
        List<ICommand> commands = commandGenerator.generateCommands(reader, commandParser);

        commands.forEach(command -> command.assignExecutor(robotExecutor));
        commands.forEach(command -> command.execute());

        reader.close();
    }
}
