package by.epam.tasks.task1.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileValidator {
    public static void main(String[] args) {
        System.out.println(new FileValidator().isFileExistStream("array.txt"));
    }

    public boolean isFileExistStream(String fileName) {
        String root = System.getProperty("user.dir");
        String filePath = root+ File.separator+"data";
        Path path = Path.of(filePath); //нужно
        Path pathResolve = path.resolve(fileName);
        Stream<Path> pathStream = null;
        boolean match = false;
        try {
            pathStream = Files.list(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            match = pathStream.anyMatch(p -> p.equals(pathResolve));
        } catch (NullPointerException ignored) {
        } finally {
            pathStream.close();
        }
        return match;
    }

    public boolean isFileExist(String fileName) throws IOException {
        String root = System.getProperty("user.dir");
        String filePath = root+ File.separator+"data";
        Path path = Path.of(filePath);
        Path pathResolve = path.resolve(fileName);
        Stream<Path> pathStream = Files.list(path);
        boolean match;
        try {
            match = pathStream.anyMatch(p -> p.equals(pathResolve));
        } finally {
            pathStream.close();
        }
        return match;
    }
}
