package ToyRobot.src.Executor;

import java.util.logging.Logger;

enum Direction {
    WEST,
    NORTH,
    EAST,
    SOUTH
}

public class RobotExecutor {
    private Table table;

    private boolean isOnTheTable;
    private Direction direction;
    private Position position;

    static Logger logger = Logger.getLogger(RobotExecutor.class.getName());

    public RobotExecutor(Table table) {
        this.table = table;
        isOnTheTable = false;
    }

    public Table getTable() { return table; }

    public void jumpOnTable(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
        this.isOnTheTable = true;
    }

    public void doMOVE() {
        if (!isOnTheTable) {
            logger.warning("Robot not on the table, ignore.");
            return;
        }

        Position newPosition;
        switch (direction) {
            case WEST:
                newPosition = new Position(position.x() - 1, position.y());
                break;
            case NORTH:
                newPosition = new Position(position.x(), position.y() + 1);
                break;
            case EAST:
                newPosition = new Position(position.x() + 1, position.y());
                break;
            case SOUTH:
                newPosition = new Position(position.x(), position.y() - 1);
                break;
            default:
                logger.warning("Failed to resolve direction in MOVE command, ignore");
                return;
        }

        if (!table.isValidPosition(newPosition)) {
            logger.warning("Invalid MOVE command, ignore");
            return;
        }
        this.position = newPosition;
    }

    public void doLEFT() {
        if (!isOnTheTable) {
            logger.warning("Robot not on the table, ignore.");
            return;
        }
        switch (direction) {
            case WEST:
                direction = Direction.SOUTH;
                break;
            case NORTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
        }
    }

    public void doRIGHT() {
        if (!isOnTheTable) {
            logger.warning("Robot not on the table, ignore.");
            return;
        }
        switch (direction) {
            case WEST:
                direction = Direction.NORTH;
                break;
            case NORTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
        }
    }

    public void doREPORT() {
        logger.info(String.format("Robot is currently in location: (%d, %d) facing to (%s)",
                position.x(),
                position.y(),
                direction.toString()));
    }

}
