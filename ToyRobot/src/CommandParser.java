package ToyRobot.src;

import ToyRobot.src.Commands.*;

import java.util.List;
import java.util.logging.Logger;

public class CommandParser {

    private static Logger logger = Logger.getLogger(CommandParser.class.getName());

    public ICommand convertToCommand(List<String> rawCommand) {
        try {
            switch (rawCommand.get(0)) {
                case "PLACE":
                    return new PlaceCommand(rawCommand.subList(1, rawCommand.size()));
                case "MOVE":
                    return new MoveCommand();
                case "LEFT":
                    return new LeftCommand();
                case "RIGHT":
                    return new RightCommand();
                case "REPORT":
                    return new ReportCommand();
            }
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Invalid command in convertToCommand.");
        }

        return null;
    }
}
