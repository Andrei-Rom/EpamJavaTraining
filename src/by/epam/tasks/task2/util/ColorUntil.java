package by.epam.tasks.task2.util;

import by.epam.tasks.task2.entity.Color;

import java.util.Arrays;
import java.util.Random;

public class ColorUntil {

    public Color getRandomColor (){
        return  Color.values()[new Random().nextInt(Color.values().length)];
    }

    public boolean isValidColor (String color){
        return Arrays.stream(Color.values()).anyMatch(s -> s.name().equalsIgnoreCase(color));
    }
}
