package ToyRobot.src.Commands;

import ToyRobot.src.Executor.RobotExecutor;

public interface ICommand {
    void assignExecutor(RobotExecutor robot);
    void execute();
}
