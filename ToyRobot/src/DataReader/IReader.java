package ToyRobot.src.DataReader;

import java.util.List;

public interface IReader {
    boolean hasNext();
    List<String> getNext();
    void close();
}
