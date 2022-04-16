package by.epam.tasks.task2.util.sort;

import by.epam.tasks.task2.entity.CustomArray;

public class SelectionSort implements CustomArraySort {
    //O(n^2)
    @Override
    public CustomArray sort(CustomArray array) {
        int[] arrayToSort = array.getArray();
        for (int left = 0; left < arrayToSort.length; left++) {
            int minInd = left;
            for (int i = left; i < arrayToSort.length; i++) {
                if (arrayToSort[i] < arrayToSort[minInd]) {
                    minInd = i;
                }
            }
            swap(arrayToSort, left, minInd);
        }
        return new CustomArray(arrayToSort);
    }

    private void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
