package by.epam.tasks.task2.util.sort;

import by.epam.tasks.task2.entity.CustomArray;

public class InsertionSort implements CustomArraySort {
    //O(n^2)
    @Override
    public CustomArray sort(CustomArray array) {
        int[] arrayToSort = array.getArray();
        for (int left = 0; left < arrayToSort.length; left++) {
            int value = arrayToSort[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arrayToSort[i]) {
                    arrayToSort[i + 1] = arrayToSort[i];
                } else {
                    break;
                }
            }
            arrayToSort[i + 1] = value;
        }
        return new CustomArray(arrayToSort);
    }
}
