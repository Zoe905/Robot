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
    private int currentX;
    private int currentY;

    static Logger logger = Logger.getLogger(RobotExecutor.class.getName());

    public RobotExecutor(Table table) {
        this.table = table;
        isOnTheTable = false;
    }

    public boolean checkPLACE(String... locations) {
//        try { ?? Do we still need if upper stream already validate the length of input
//        } catch (IndexOutOfBoundsException e) {
//            return false;
//        }
        try {
            return table.isValidPosition(Integer.valueOf(locations[0]), Integer.valueOf(locations[1]));
        } catch (NumberFormatException e) {
            logger.warning(String.format("Invalid PLACE command: %s %s"));
        }
        return false;
    }

    public boolean checkMOVE() {
        if (!isOnTheTable) return false;

        switch (direction) {
            case WEST:
                return table.isValidPosition(currentX - 1, currentY);
            case NORTH:
                return table.isValidPosition(currentX, currentY + 1);
            case EAST:
                return table.isValidPosition(currentX + 1, currentY);
            case SOUTH:
                return table.isValidPosition(currentX, currentY - 1);
        }
        return false;
    }

    public boolean checkOnTheTable() {
        return isOnTheTable;
    }


    public void doPLACE(String... locations) {
//        try { ?? Do we still need if upper stream already validate the length of input
//        } catch (IndexOutOfBoundsException e) {
//            return false;
//        }
        currentX = Integer.valueOf(locations[0]);
        currentY = Integer.valueOf(locations[1]);
        direction = Direction.valueOf(locations[2]);
        isOnTheTable = true;
    }

    public void doMOVE() {
        switch (direction) {
            case WEST:
                currentX -= 1;
                break;
            case NORTH:
                currentY += 1;
                break;
            case EAST:
                currentX += 1;
                break;
            case SOUTH:
                currentY -= 1;
                break;
        }
    }

    public void doLEFT() {
        // TODO: There must be a cleaner way to achieve this
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
        // TODO: There must be a cleaner way to achieve this
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
        logger.info(String.format("Robot is currently in location: (%d, %d) facing to (%s)", currentX, currentY,
                direction.toString()));
    }

}
