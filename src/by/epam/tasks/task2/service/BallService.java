package by.epam.tasks.task2.service;

import by.epam.tasks.task2.entity.Ball;
import by.epam.tasks.task2.entity.Basket;
import by.epam.tasks.task2.entity.Color;

public class BallService {

    public int calculateBasketWeight(Basket basket) {
        return basket.getBasket().stream().mapToInt(Ball::getWeight).sum();
    }

    public int calculateQuantityOfBallsByColor(Basket basket, Color color) {
        return (int) basket.getBasket().stream().filter(s -> s.getColor().equals(color)).count();
    }
}
