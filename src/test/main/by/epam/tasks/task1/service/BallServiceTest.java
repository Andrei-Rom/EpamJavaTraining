package main.by.epam.tasks.task1.service;

import main.by.epam.tasks.task1.entity.Ball;
import main.by.epam.tasks.task1.entity.Basket;
import main.by.epam.tasks.task1.entity.Color;
import main.by.epam.tasks.task1.service.BallService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BallServiceTest {
    Basket basket;
    BallService ballService;

    @BeforeEach
    public void setUp() {
        basket = new Basket();
        List<Ball> balls = new ArrayList<>();
        balls.add(new Ball(5, Color.BLACK));
        balls.add(new Ball(15, Color.BLUE));
        balls.add(new Ball(10, Color.CYAN));
        balls.add(new Ball(1, Color.BLACK));
        balls.add(new Ball(20, Color.BLACK));
        balls.add(new Ball(85, Color.YELLOW));
        balls.add(new Ball(100, Color.CYAN));
        basket.setBalls(balls);
        ballService = new BallService();
    }

    @Test
    public void testCalculateBasketWeight() {
        Assertions.assertEquals(236, ballService.calculateBasketWeight(basket));
    }

    @Test
    public void testCalculateBasketWeightStream() {
        Assertions.assertEquals(236, ballService.calculateBasketWeightStream(basket));
    }

    @Test
    public void testCalculateWeightByColor() {
        Assertions.assertEquals(26, ballService.calculateWeightByColor(basket, Color.BLACK));
    }

    @Test
    public void testCalculateWeightByColorStream() {
        Assertions.assertEquals(26, ballService.calculateWeightByColorStream(basket, Color.BLACK));
    }

    @Test
    public void testCalculateQuantityOfBallsByColor() {
        Assertions.assertEquals(2, ballService.calculateQuantityOfBallsByColor(basket, Color.CYAN));
    }

    @Test
    public void testCalculateQuantityOfBallsByColorStream() {
        Assertions.assertEquals(2,ballService.calculateQuantityOfBallsByColorStream(basket, Color.CYAN));
    }

}
