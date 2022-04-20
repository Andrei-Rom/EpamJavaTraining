package main.by.epam.tasks.task1.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readFile(String fileName) {
        FileValidator validator = new FileValidator();
        List<String> lines = new ArrayList<>();
        if (validator.isFileExistStream(fileName)) {
            String root = System.getProperty("user.dir");
            String filePath = root + File.separator + "resources" + File.separator + "data" + File.separator + fileName;
            File file = new File(filePath);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    lines.add(line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }
}
