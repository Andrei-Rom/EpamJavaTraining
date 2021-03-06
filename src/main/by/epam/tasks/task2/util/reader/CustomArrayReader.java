package main.by.epam.tasks.task2.util.reader;

import main.by.epam.tasks.task1.util.FileReader;
import main.by.epam.tasks.task2.entity.CustomArray;

import java.util.List;

public class CustomArrayReader {

    // any positive and negative integers, zero, excluding -0
    public static final String REGEX_INTEGER = "-?[1-9]\\d*|0";

    public CustomArray getArrayFromFile(String fileName) {
        CustomArray customArray = new CustomArray();
        List<String> strings = new FileReader().readFile(fileName);

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
