package by.epam.tasks.task1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileValidator {

    public boolean isFileExistStream(String fileName) {
        Path path = Path.of("\\data");
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
        Path path = Path.of("\\data");
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
