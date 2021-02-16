package ToyRobot.src.Executor;

public class Position {
    private int currentX;
    private int currentY;

    public Position(int x, int y) {
        currentX = x;
        currentY = y;
    }

    public int x() { return currentX; }
    public int y() { return currentY; }
}
