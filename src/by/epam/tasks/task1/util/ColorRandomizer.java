package by.epam.tasks.task1.util;

import by.epam.tasks.task1.entity.Color;

import java.util.Random;

public class ColorRandomizer {

    public Color getRandomColor() {
        return Color.values()[new Random().nextInt(Color.values().length)];
    }
}
