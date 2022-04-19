package main.by.epam.tasks.task1.util;

import java.util.regex.Pattern;

public class WeightValidator {

    public static final String REGEX_PPOSITIVE_INT = "[0-9]+]";

    public boolean checkNumber(String string) {
        return Pattern.matches(REGEX_PPOSITIVE_INT, string);
    }
}
