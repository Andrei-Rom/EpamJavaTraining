package main.by.epam.tasks.task2.util.sort;


import main.by.epam.tasks.task2.entity.CustomArray;
import main.by.epam.tasks.task2.util.sort.BubbleSort;
import main.by.epam.tasks.task2.util.sort.HeapSort;
import main.by.epam.tasks.task2.util.sort.InsertionSort;
import main.by.epam.tasks.task2.util.sort.SelectionSort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTest {
    int[] array;
    int[] expecteds;
    CustomArray customArray;

    @BeforeEach
    public void setUp() {
        array = new int[]{1, 2, 3, 14, 25, 610, -35, 0, 170, -18, -315, 89, 197};
        expecteds = new int[]{-315, -35, -18, 0, 1, 2, 3, 14, 25, 89, 170, 197, 610};
        customArray = new CustomArray(array);
    }

    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(customArray);
        sortTest(customArray);
    }

    @Test
    public void testHeapSort() {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(customArray);
        sortTest(customArray);
    }

    @Test
    public void testInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(customArray);
        sortTest(customArray);
    }

    @Test
    public void testSelectionSort() {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(customArray);
        sortTest(customArray);
    }

    private void sortTest(CustomArray actual) {
        Assertions.assertArrayEquals(expecteds, actual.getArray());
    }
}
