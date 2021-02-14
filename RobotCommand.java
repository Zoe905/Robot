import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class RobotCommand implements Command{
    private CommandType type;
    private Robot executor;
    private String[] extraCommand;
    Logger logger = Logger.getLogger(RobotCommand.class.getName());

    public RobotCommand(Robot robot, String... commandType) {
        try {
            type = CommandType.valueOf(commandType[0]);
            executor = robot;
            if (type == CommandType.PLACE) {
                extraCommand = new String[] {commandType[1], commandType[2], commandType[3]};
            }
        } catch (IllegalArgumentException e1) {
            logger.warning(String.format("Unknown command detected: %s, will ignore it.", commandType[0]));
            type = CommandType.UNKNOWN;
        } catch (IndexOutOfBoundsException e2) {
            logger.warning("No command typs is passed in.");
            type = CommandType.UNKNOWN;
        }
    }

    @Override
    public void execute() {
        if (type == CommandType.UNKNOWN)
            return;
        executor.action(type, extraCommand);
    }
}
