package ToyRobot.src;

import ToyRobot.src.Commands.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommandParser {

    private static Logger logger = Logger.getLogger(CommandParser.class.getName());

    public List<List<String>> readFromFile(String fileName) {
        List<List<String>> rawCommands = new ArrayList<List<String>>();

        try {
            Scanner s = new Scanner(new File("ToyRobot/data/testData"));
            while (s.hasNext()){
                rawCommands.add(Arrays.asList(s.nextLine().split(" ")));
            }
            s.close();
        } catch(FileNotFoundException e) {
            logger.warning("Invalid file name. Please try another one.");
        }

        return rawCommands;
    }

    public List<ICommand> convertToCommand(List<List<String>> rawCommands) {
        List<ICommand> commands = new ArrayList<>();

        for (List<String> rawCommand : rawCommands) {
            try {
                switch (rawCommand.get(0)) {
                    case "PLACE":
                        commands.add(new PlaceCommand(rawCommand.subList(1, rawCommand.size())));
                        break;
                    case "MOVE":
                        commands.add(new MoveCommand());
                        break;
                    case "LEFT":
                        commands.add(new LeftCommand());
                        break;
                    case "RIGHT":
                        commands.add(new RightCommand());
                        break;
                    case "REPORT":
                        commands.add(new ReportCommand());
                        break;
                }
            } catch (IndexOutOfBoundsException e) {
                logger.warning("Invalid command in convertToCommand.");
            }
        }

        return commands;
    }
}
