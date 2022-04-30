package main.by.epam.tasks.task3.service;

import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.Arrays;

public class CustomizableArrayService {

    public int findMax(CustomizableArray array) {
        return Arrays.stream(array.getArray()).max().getAsInt();
    }

    public int findMin(CustomizableArray array) {
        return Arrays.stream(array.getArray()).min().getAsInt();
    }

    public double findAverage(CustomizableArray array) {
        return Arrays.stream(array.getArray()).average().getAsDouble();
    }

    public int findSum(CustomizableArray array) {
        return Arrays.stream(array.getArray()).sum();
    }
}
