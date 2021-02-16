package ToyRobot.src.Executor;

import java.util.logging.Logger;

public class Table {
    public final int TABLE_SIZE = 5;

    private static Logger logger = Logger.getLogger(Table.class.getName());

    public boolean isValidPosition(Position position) {
        logger.info(String.format("Received new locations in table: (%d, %d)", position.x(), position.y()));
        return position.x() >= 0
                && position.x() < TABLE_SIZE
                && position.y() >= 0
                && position.y() < TABLE_SIZE;
    }
}
