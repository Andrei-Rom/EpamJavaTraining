package by.epam.tasks.task2;

import jdk.internal.util.ArraysSupport;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int [] array = new int[10];
        Arrays.stream(array).max();
        list.add(1);
      //  System.out.println(ArraysSupport.newLength(10,11 - 10,10 >> 1 ));
        System.out.println(10>>1);
    }
}
