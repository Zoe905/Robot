import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Read the commands from a file
        ;

        Table table = new Table();
        Robot robot = new Robot(table);
        Command command = new RobotCommand(robot, new String[] {"PLACE", "1", "1", "EAST"});
        command.execute();
        Command command1 = new RobotCommand(robot, new String[] {"LEFT"});
        command1.execute();
        Command command2 = new RobotCommand(robot, new String[] {"REPORT"});
        command2.execute();
    }
}
