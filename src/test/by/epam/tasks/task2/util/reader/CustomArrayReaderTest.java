package test.by.epam.tasks.task2.util.reader;

import main.by.epam.tasks.task2.util.reader.CustomArrayReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomArrayReaderTest {

    @Test
    public void testGetArrayFromFile() {
        int[] expecteds = new int[]{0, 25, 3, -150, 22, -16, 52, 11, 1, 999, 18};
        CustomArrayReader reader = new CustomArrayReader();
        Assertions.assertArrayEquals(reader.getArrayFromFile("array.txt").getArray(), expecteds);
    }
}
