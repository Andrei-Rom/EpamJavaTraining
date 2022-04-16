package by.epam.tasks.task2.util.reader;

import by.epam.tasks.task1.util.FileReader;
import by.epam.tasks.task2.entity.CustomArray;

import java.util.Arrays;
import java.util.List;

public class CustomArrayReader {

    public CustomArray getArrayFromFile(String fileName) {
        CustomArray customArray = new CustomArray();
        List<String> strings = new FileReader().readFile(fileName);

        for (String s : strings) {
            String[] numbers = s.split(",");
            for (String number : numbers) {
                String num = number.trim();
                if (num.matches("T(-{0,1}(?!0)\\d+)")) {
                    customArray.add(Integer.parseInt(num));
                }
            }
        }
        return new CustomArray();
    }
}
