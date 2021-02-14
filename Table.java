public class Table {
    public final int TABLE_SIZE = 5;

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < TABLE_SIZE && y >= 0 && y < TABLE_SIZE;
    }
}
