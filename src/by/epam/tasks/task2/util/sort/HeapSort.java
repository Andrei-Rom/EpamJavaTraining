package by.epam.tasks.task2.util.sort;

import by.epam.tasks.task2.entity.CustomArray;

public class HeapSort implements CustomArraySort{
    //O(n logn)
    @Override
    public CustomArray sort(CustomArray array) {
        int[] arrayToSort = array.getArray();
        for (int i = arrayToSort.length / 2 - 1; i >= 0; i--)
            shiftDown(arrayToSort, i, arrayToSort.length);
        for (int i = arrayToSort.length - 1; i > 0; i--) {
            swap(arrayToSort, 0, i); /* deleteMax */
            shiftDown(arrayToSort, 0, i);
        }
        return new CustomArray(arrayToSort);
    }

    private static void shiftDown(int[] a, int i, int n) {
        int child;
        int tmp;

        for (tmp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && (a[child] < a[child + 1]))
                child++;
            if (tmp < a[child])
                a[i] = a[child];
            else
                break;
        }
        a[i] = tmp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
