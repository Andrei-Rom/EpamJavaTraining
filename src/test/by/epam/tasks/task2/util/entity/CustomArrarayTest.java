package test.by.epam.tasks.task2.util.entity;

import by.epam.tasks.task2.entity.CustomArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomArrarayTest {
    CustomArray array;

    @Test
    public void testAdd() {
        array = new CustomArray();
        array.add(3);
        array.add(4);
        array.add(8);
        array.add(-100);
        array.add(65);
        array.add(0);
        array.add(34);
        int[] expecteds = new int[]{3, 4, 8, -100, 65, 0, 34};
        Assertions.assertArrayEquals(expecteds, array.getArray());
    }

    @Test
    public void testgetSize() {
        array = new CustomArray(new int[]{3, 4, 8, -100, 65, 0, 34});
        Assertions.assertEquals(7, array.getSize());
    }

    @Test
    public void testCustomArray1() {
        array = new CustomArray(3);
        Assertions.assertEquals(0, array.getSize());
    }

    @Test
    public void testCustomArray2() {
        int[] expecteds = new int[]{3, 4, 8, -100, 65, 0, 34};
        array = new CustomArray(expecteds);
        Assertions.assertArrayEquals(expecteds, array.getArray());
    }
}
