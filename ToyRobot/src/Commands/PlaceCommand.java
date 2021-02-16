package ToyRobot.src.Commands;

import java.util.List;
import java.util.logging.Logger;

import ToyRobot.src.Executor.Position;
import ToyRobot.src.Executor.RobotExecutor;
import ToyRobot.src.Executor.RobotSimulator;

public class PlaceCommand implements ICommand {
    private RobotSimulator simulator;
    private List<String> extraCommand;

    private static Logger logger = Logger.getLogger(PlaceCommand.class.getName());

    public PlaceCommand(List<String> extraCommand) {
        this.extraCommand = extraCommand;
    }

    @Override
    public void assignExecutor(RobotExecutor executor) {

        this.simulator = new RobotSimulator(executor, executor.getTable());
    }

    @Override
    public void execute() {
        if(simulator == null)
            logger.warning("Haven't assigned executor for simulator in ToyRobot.src.Commands.PlaceCommand");

        try {
            Position position = new Position(Integer.valueOf(extraCommand.get(0)), Integer.valueOf(extraCommand.get(1)));
            String direction = extraCommand.get(2);
            simulator.doPLACE(position, direction);
        } catch (IndexOutOfBoundsException e) {
            logger.warning("Failed to extract location and direction info from Place command.");
        } catch (NumberFormatException e) {
            logger.warning(String.format("Location info is invalid for PLACE command: %s"));
        }
    }
}
