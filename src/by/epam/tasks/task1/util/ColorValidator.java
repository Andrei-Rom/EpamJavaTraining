package by.epam.tasks.task1.util;

import by.epam.tasks.task1.entity.Color;

import java.util.Arrays;

public class ColorValidator {

    public boolean isValidColor(String color) {
        return Arrays.stream(Color.values())
                .anyMatch(s -> s.name()
                        .equalsIgnoreCase(color));
    }
}
