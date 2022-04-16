package by.epam.tasks.task2.util.sort;

import by.epam.tasks.task2.entity.CustomArray;

public class BubbleSort implements CustomArraySort{
    //O(n^2)
    @Override
    public CustomArray sort(CustomArray array) {
        int[] arrayToSort = array.getArray();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < arrayToSort.length; i++) {
                if (arrayToSort[i] < arrayToSort[i - 1]) {
                    swap(arrayToSort, i, i-1);
                    needIteration = true;
                }
            }
        }
        return new CustomArray(arrayToSort);
    }

    private void swap (int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
