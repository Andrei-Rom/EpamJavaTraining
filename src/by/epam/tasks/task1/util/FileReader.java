package by.epam.tasks.task1.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readFile (String fileName){
        FileValidator validator = new FileValidator();
        List<String> lines = new ArrayList<>();
        if (validator.isFileExistStream(fileName)){
            Scanner scanner  = null;
            try {
                scanner = new Scanner(new File(fileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                lines.add(line);
            }
        }
        return lines;
    }
}
