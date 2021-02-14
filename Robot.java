import java.util.logging.Logger;

enum Direction {
    WEST,
    NORTH,
    EAST,
    SOUTH
}

public class Robot {
    private Table table;

    private boolean isOnTheTable;
    private Direction direction;
    private int currentX;
    private int currentY;

    static Logger logger = Logger.getLogger(Robot.class.getName());

    public Robot(Table table) {
        this.table = table;
        isOnTheTable = false;
    }

    public void action(CommandType commandType, String... extraCommand) {
        if (!isValidAction(commandType, extraCommand)){
            logger.warning("Command is not valid, will not proceed.");
            return;
        }
        doAction(commandType, extraCommand);
    }

    private boolean isValidAction(CommandType commandType, String... extraCommand) {
        switch (commandType) {
            case PLACE:
                return checkPLACE(extraCommand);
            case MOVE:
                return checkMOVE();
            case LEFT:
                return checkLEFT();
            case RIGHT:
                return checkRIGHT();
            case REPORT:
                return checkREPORT();
        }
        return false;
    }

    private void doAction(CommandType commandType, String... extraCommand) {
        switch (commandType) {
            case PLACE:
                doPLACE(extraCommand);
                break;
            case MOVE:
                doMOVE();
                break;
            case LEFT:
                doLEFT();
                break;
            case RIGHT:
                doRIGHT();
                break;
            case REPORT:
                doREPORT();
                break;
        }
    }

    private boolean checkPLACE(String... locations) {
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

    private boolean checkMOVE() {
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

    private boolean checkLEFT() {
        return isOnTheTable;
    }

    private boolean checkRIGHT() {
        return isOnTheTable;
    }

    private boolean checkREPORT() {
        return isOnTheTable;
    }

    private void doPLACE(String... locations) {
//        try { ?? Do we still need if upper stream already validate the length of input
//        } catch (IndexOutOfBoundsException e) {
//            return false;
//        }
        int targetX = Integer.valueOf(locations[0]);
        int targetY = Integer.valueOf(locations[1]);
        direction = Direction.valueOf(locations[2]);
        isOnTheTable = true;
    }

    private void doMOVE() {
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

    private void doLEFT() {
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

    private void doRIGHT() {
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

    private void doREPORT() {
        logger.info(String.format("Robot is currently in location: (%d, %d) facing to (%s)", currentX, currentY,
                direction.toString()));
    }

}
