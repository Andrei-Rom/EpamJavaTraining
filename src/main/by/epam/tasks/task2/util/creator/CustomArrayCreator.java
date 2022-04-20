package main.by.epam.tasks.task2.util.creator;

import main.by.epam.tasks.task2.entity.CustomArray;

import java.util.List;

public class CustomArrayCreator {

    // any positive and negative integers, zero, excluding -0
    private static final String REGEX_INTEGER = "-?[1-9]\\d*|0";

    public CustomArray createCustomArray(List<String> strings) {
        CustomArray customArray = new CustomArray();
        for (String s : strings) {
            String[] numbers = s.split(",");
            for (String number : numbers) {
                String num = number.trim();
                if (num.matches(REGEX_INTEGER)) {
                    customArray.add(Integer.parseInt(num));
                }
            }
        }
        return customArray;
    }
}
