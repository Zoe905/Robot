package ToyRobot.src.DataReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileReader implements IReader{
    private Scanner scanner;
    private static Logger logger = Logger.getLogger(FileReader.class.getName());

    public FileReader(String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new File(fileName));
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
