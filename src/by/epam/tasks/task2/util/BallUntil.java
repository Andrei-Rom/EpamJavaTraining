package by.epam.tasks.task2.util;

import by.epam.tasks.task2.entity.Color;

import java.util.Random;

public class BallUntil {

    public Color getRandomColor (){
        return  Color.values()[new Random().nextInt(Color.values().length)];

    }
}
