package test.by.epam.tasks.task2.math;

import by.epam.tasks.task2.entity.CustomArray;
import by.epam.tasks.task2.util.math.CustomArrays;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class CustomArraysTest {
    CustomArray customArray;
    CustomArrays arrays;

    @BeforeMethod
    public void setUp() {
        int[] array = new int[]{1, 2, 3, 14, 25, 610, -35, 0, 170, -18, -315, 89, 197};
        customArray = new CustomArray(array);
        arrays = new CustomArrays();
    }

    @Test
    public void testGetArrayFromFile() {
        int[] expecteds = new int[]{25, 3, 18, -150, 22};
        assertArrayEquals(expecteds, arrays.getArrayFromFile("array.txt").getArray());
    }

    @Test
    public void testGetFibonacciNumbers() {
        int[] expecteds = new int[]{0, 1, 2, 3, 610};
        assertArrayEquals(expecteds, arrays.getFibonacciNumbers(customArray).getArray());
    }

    @Test
    public void testGetPrimeNumbers() {
        int[] expecteds = new int[]{2, 3, 89, 197};
        assertArrayEquals(expecteds, arrays.getPrimeNumbers(customArray).getArray());
    }

    @Test
    public void testGetRandomArray() {
        boolean test = arrays.getRandomArray().getClass().equals(customArray.getClass());
        assertTrue(test);
    }

    @Test
    public void testGetThreeDigitNumberOfUniqueDigits() {
        int[] expecteds = new int[]{610, 170, -315, 197};
        assertArrayEquals(expecteds, arrays.getThreeDigitNumberOfUniqueDigits(customArray).getArray());
    }

    @Test
    public void testIsElementExist() {
        assertTrue(arrays.isElementExist(170, customArray));
    }

    @Test
    public void testMax() {
        assertEquals(610, arrays.max(customArray));
    }

    @Test
    public void testMin() {
        assertEquals(-315, arrays.min(customArray));
    }
}
