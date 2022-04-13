package by.epam.tasks.task2.until;

import by.epam.tasks.task2.entity.Color;

import java.util.Random;

public class ColorUntil {

    public Color getRandomColor (){
        return  Color.values()[new Random().nextInt(Color.values().length)];

    }

    public boolean isValidColor (String color){
        for (Color c: Color.values()) {
            if (c.name().equalsIgnoreCase(color)) {
            return true;
            }
        }
        return false;
    }
}
