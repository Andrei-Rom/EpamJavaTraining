package by.epam.tasks.task2.util.math;

import by.epam.tasks.task2.entity.CustomArray;

import java.util.*;
import java.util.stream.IntStream;

public class CustomArrays {

    public static void main(String[] args) {
        int[] arr = new int[]{199,-123,-196,365,122,333,999,158,155,-1000};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 101 && arr[i] <988 || arr[i] < -101 && arr[i] >-988) {
                int units = arr[i] % 10;

                int tens = ((arr[i]) % 100)/10;

                int hundreds = arr[i]/100;

                if ((units != tens) && tens!= hundreds && units != hundreds){
                    System.out.println(arr[i]);
                }
            }
        }
    }

    public boolean isElementExist(int element, CustomArray array) {
        int[] arr = array.getArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) return true;
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
            if (arr[i] > min) {
                min = arr[i];
            }
        }
        return min;
    }

    public CustomArray getPrimeNumbers(CustomArray array) {
        int[] arr = array.getArray();
        CustomArray customArray = new CustomArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>=2 && isPrime(arr[i])){
                customArray.add(arr[i]);
            }
        }
        return customArray;
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).anyMatch(i -> number % i == 0);
    }


    public CustomArray getFibonacciNumbers(CustomArray array) {
        CustomArray customArray = new CustomArray();
        int max = new CustomArrays().max(array);
        int[] arr = array.getArray();
        int[] fibonacciNumbers = new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986,102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903};
        int index = 0;
        while (index <= 44 && max < fibonacciNumbers[index]){
            index = index+ 1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >=0 ) {
                for (int j = 0; j <= index; j++) {
                    if (arr[i] < fibonacciNumbers[j]){
                        break;
                    }
                    if(arr[i] == fibonacciNumbers[j]){
                        customArray.add(arr[i]);
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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 101 && arr[i] <988 || arr[i] < -101 && arr[i] >-988) {
                int units = arr[i] % 10;
                int tens = ((arr[i]) % 100)/10;
                int hundreds = arr[i]/100;
                if ((units != tens) && tens!= hundreds && units != hundreds){
                    customArray.add(arr[i]);
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
