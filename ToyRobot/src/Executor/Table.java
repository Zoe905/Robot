package ToyRobot.src.Executor;

import java.util.logging.Logger;

public class Table {
    public final int TABLE_SIZE = 5;

    private static Logger logger = Logger.getLogger(Table.class.getName());

    public boolean isValidPosition(int x, int y) {
        logger.info(String.format("Received new locations in table: (%d, %d)", x, y));
        return x >= 0 && x < TABLE_SIZE && y >= 0 && y < TABLE_SIZE;
    }
}
