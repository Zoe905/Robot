package ToyRobot.src.Commands;

import java.util.List;
import java.util.logging.Logger;

import ToyRobot.src.Executor.RobotExecutor;

public class PlaceCommand implements ICommand {
    private RobotExecutor executor;
    private List<String> extraCommand;

    private static Logger logger = Logger.getLogger(PlaceCommand.class.getName());

    public PlaceCommand(List<String> extraCommand) {
        this.extraCommand = extraCommand;
    }

    @Override
    public void assignExecutor(RobotExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        if(executor == null)
            logger.warning("Haven't assigned executor for ToyRobot.src.Commands.PlaceCommand");

        try {
            String locationX = extraCommand.get(0);
            String locationY = extraCommand.get(1);
            String direction = extraCommand.get(2);
            if (executor.checkPLACE(locationX, locationY, direction))
                executor.doPLACE(locationX, locationY, direction);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Failed to extract location and direction info from Place command.");
        }
    }
}
