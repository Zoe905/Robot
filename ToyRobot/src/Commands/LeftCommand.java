package ToyRobot.src.Commands;

import java.util.List;
import java.util.logging.Logger;

import ToyRobot.src.Executor.RobotExecutor;

public class LeftCommand implements ICommand {
    private RobotExecutor executor;
    private List<String> extraCommand;

    private static Logger logger = Logger.getLogger(LeftCommand.class.getName());

    @Override
    public void assignExecutor(RobotExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void execute() {
        if(executor == null)
            logger.warning("Haven't assigned executor for ToyRobot.src.Commands.LeftCommand");
        if (executor.checkOnTheTable())
            executor.doLEFT();
    }
}
