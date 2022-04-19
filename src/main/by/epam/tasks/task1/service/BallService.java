package main.by.epam.tasks.task1.service;

import main.by.epam.tasks.task1.entity.Ball;
import main.by.epam.tasks.task1.entity.Basket;
import main.by.epam.tasks.task1.entity.Color;

import java.util.List;

public class BallService {

    public int calculateBasketWeightStream(Basket basket) {
        return basket.getBalls().stream().mapToInt(Ball::getWeight).sum();
    }

    public int calculateBasketWeight(Basket basket) {
        int basketWeight = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball ball : balls) {
            basketWeight += ball.getWeight();
        }
        return basketWeight;
    }

    public int calculateQuantityOfBallsByColorStream(Basket basket, Color color) {
        return (int) basket.getBalls().stream().filter(s -> s.getColor().equals(color)).count();
    }

    public int calculateQuantityOfBallsByColor(Basket basket, Color color) {
        int quantity = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball ball : balls) {
            if (ball.getColor().equals(color)) {
                quantity++;
            }
        }
        return quantity;
    }

    public int calculateWeightByColorStream(Basket basket, Color color) {
        return basket.getBalls().stream().filter(s -> s.getColor().equals(color)).mapToInt(Ball::getWeight).sum();
    }

    public int calculateWeightByColor(Basket basket, Color color) {
        int weight = 0;
        List<Ball> balls = basket.getBalls();
        for (Ball ball : balls) {
            if (ball.getColor().equals(color)) {
                weight = weight + ball.getWeight();
            }
        }
        return weight;
    }
}
