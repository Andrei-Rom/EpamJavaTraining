package by.epam.tasks.task3.until;

import by.epam.tasks.task2.entity.Ball;
import by.epam.tasks.task2.entity.Basket;

import java.util.ArrayList;
import java.util.List;

public class BasketReader {
    private List<String> balls;

    public BasketReader(List<String> balls) {
        this.balls = balls;
    }

    public Basket readBasket (List<String> basket) {

        return new Basket();
    }
}
