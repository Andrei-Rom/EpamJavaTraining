package main.by.epam.tasks.task2.util.math;

import main.by.epam.tasks.task2.entity.CustomArray;
import main.by.epam.tasks.task2.util.math.CustomArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomArraysTest {
    CustomArray customArray;
    CustomArrays arrays;

    @BeforeEach
    public void setUp() {
        int[] array = new int[]{1, 2, 3, 14, 25, 610, -35, 610, 0, 170, -18, -315, 89, 197};
        customArray = new CustomArray(array);
        arrays = new CustomArrays();
    }

    @Test
    public void testGetFibonacciNumbers() {
        int[] expecteds = new int[]{1, 2, 3, 610, 610, 0, 89};
        Assertions.assertArrayEquals(expecteds, arrays.getFibonacciNumbers(customArray).getArray());
    }

    @Test
    public void testGetPrimeNumbers() {
        int[] expecteds = new int[]{2, 3, 89, 197};
        Assertions.assertArrayEquals(expecteds, arrays.getPrimeNumbers(customArray).getArray());
    }

    @Test
    public void testGetRandomArray() {
        boolean test = arrays.getRandomArray(customArray.getSize()).getClass().equals(customArray.getClass());
        Assertions.assertTrue(test);
    }

    @Test
    public void testGetThreeDigitNumberOfUniqueDigits() {
        int[] expecteds = new int[]{610, 610, 170, -315, 197};
        Assertions.assertArrayEquals(expecteds, arrays.getThreeDigitNumberOfUniqueDigits(customArray).getArray());
    }

    @Test
    public void testIsElementExist1() {
        Assertions.assertTrue(arrays.isElementExist(customArray, 170));
    }

    @Test
    public void testIsElementExist2() {
        Assertions.assertFalse(arrays.isElementExist(customArray, 1010));
    }

    @Test
    public void testMax() {
        Assertions.assertEquals(610, arrays.getMax(customArray));
    }

    @Test
    public void testMin() {
        Assertions.assertEquals(-315, arrays.getMin(customArray));
    }
}
