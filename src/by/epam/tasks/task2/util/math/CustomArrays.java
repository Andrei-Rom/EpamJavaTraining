package by.epam.tasks.task2.util.math;

import by.epam.tasks.task2.entity.CustomArray;

import java.util.*;
import java.util.stream.IntStream;

public class CustomArrays {
    public boolean isElementExist(CustomArray array, int number) {
        return binarySearch(array.getArray(), number);
    }

    public static boolean binarySearch(int[] input, int number) {
        input = Arrays.stream(input).sorted().toArray();
        int first = 0;
        int last = input.length - 1;
        int middle = (first + last) / 2;

        while (first <= last) {
            if (input[middle] < number) {
                first = middle + 1;
            } else if (input[middle] == number) {
                return true;
            } else {
                last = middle - 1;
            }
            middle = (first + last) / 2;
        }
        return false;
    }

    public int max(CustomArray array) {
        int[] arr = array.getArray();
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int min(CustomArray array) {
        int[] arr = array.getArray();
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public CustomArray getPrimeNumbers(CustomArray array) {
        int[] arr = array.getArray();
        CustomArray customArray = new CustomArray();
        for (int j : arr) {
            if (j >= 2 && isPrime(j)) {
                customArray.add(j);
            }
        }
        return customArray;
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }


    public CustomArray getFibonacciNumbers(CustomArray array) {
        CustomArray customArray = new CustomArray();
        int max = new CustomArrays().max(array);
        int[] arr = array.getArray();
        int[] fibonacciNumbers = new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};
        int index = 0;
        while (index <= 44 && max >= fibonacciNumbers[index]) {
            index = index + 1;
        }
        for (int k : arr) {
            if (k >= 0) {
                for (int j = 0; j <= index; j++) {
                    if (k < fibonacciNumbers[j]) {
                        break;
                    }
                    if (k == fibonacciNumbers[j]) {
                        customArray.add(k);
                        break;
                    }
                }
            }
        }
        return customArray;
    }

    public CustomArray getThreeDigitNumberOfUniqueDigits(CustomArray array) {
        CustomArray customArray = new CustomArray();
        int[] arr = array.getArray();
        for (int j : arr) {
            if (j > 101 && j < 988 || j < -101 && j > -988) {
                int units = j % 10;
                int tens = (j % 100) / 10;
                int hundreds = j / 100;
                if ((units != tens) && tens != hundreds && units != hundreds) {
                    customArray.add(j);
                }
            }
        }
        return customArray;
    }

    public CustomArray getRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt();
        }
        return new CustomArray(arr);
    }
}
