package by.epam.tasks.task1.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readFile(String fileName) {
        FileValidator validator = new FileValidator();
        List<String> lines = new ArrayList<>();
        if (validator.isFileExistStream(fileName)) {
            Scanner scanner = null;
            try {
                String root = System.getProperty("user.dir");
                String filePath = root + File.separator + "data" + File.separator + fileName;

                File file = new File(filePath);
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                assert scanner != null;
                scanner.close();
            }
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
        }
        return lines;
    }
}
