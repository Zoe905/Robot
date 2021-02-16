package ToyRobot.src.DataReader;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CmdReader implements IReader {
    private Scanner scanner;
    public CmdReader() {
        this.scanner = new Scanner(new InputStreamReader(System.in));
    }
    @Override
    public boolean hasNext() {
        return this.scanner.hasNext();
    }

    @Override
    public List<String> getNext() {
        return Arrays.asList(this.scanner.nextLine().split(" "));
    }

    @Override
    public void close() {
        this.scanner.close();
    }
}
