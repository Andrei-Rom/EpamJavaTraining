package by.epam.tasks.task1.util;

import by.epam.tasks.task1.entity.Ball;
import by.epam.tasks.task1.entity.Basket;
import by.epam.tasks.task1.entity.Color;

import java.util.ArrayList;
import java.util.List;

public class BasketReader {

    public Basket readBasket(List<String> lines) {
        List<Ball> balls = new ArrayList<>();
        Basket basket = new Basket();
        for (String line : lines) {
            if (line != null && !line.strip().isEmpty()) {
                String[] strings = line.split("\\s+");
                String weight = strings[0];
                String color = strings[1];

                if (new WeightValidator().checkNumber(weight) && new ColorValidator().isValidColor(color)) {
                    balls.add(new Ball(Integer.parseInt(weight), Color.valueOf(color)));
                }
            }
        }
        basket.setBalls(balls);
        return basket;
    }
}
