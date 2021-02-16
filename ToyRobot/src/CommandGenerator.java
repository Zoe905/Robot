package ToyRobot.src;

import ToyRobot.src.Commands.ICommand;
import ToyRobot.src.DataReader.IReader;

import java.util.ArrayList;
import java.util.List;

public class CommandGenerator {
    public List<ICommand> generateCommands(IReader reader, CommandParser commandParser) {
        List<ICommand> commands = new ArrayList<>();
        while(reader.hasNext()) {
            commands.add(commandParser.convertToCommand(reader.getNext()));
        }
        return commands;
    }
}
