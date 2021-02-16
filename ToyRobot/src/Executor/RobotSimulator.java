package ToyRobot.src.Executor;

import java.util.logging.Logger;

public class RobotSimulator {
    private RobotExecutor robot;
    private Table table;

    private static Logger logger = Logger.getLogger(RobotSimulator.class.getName());

    public RobotSimulator(RobotExecutor robot, Table table) {
        this.robot = robot;
        this.table = table;
    }

    public void doPLACE(Position position, String rawDirection) {
        if (table.isValidPosition(position)) {
            robot.jumpOnTable(position, Direction.valueOf(rawDirection));
        } else
            logger.warning("Invalid PLACE command, ignore.");

    }
}
