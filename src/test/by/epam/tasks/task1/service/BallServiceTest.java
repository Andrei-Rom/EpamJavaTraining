package test.by.epam.tasks.task1.service;

import by.epam.tasks.task1.entity.Ball;
import by.epam.tasks.task1.entity.Basket;
import by.epam.tasks.task1.entity.Color;
import by.epam.tasks.task1.service.BallService;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;





public class BallServiceTest {
    Basket basket;
    BallService ballService;

    @BeforeMethod
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
        assertEquals(ballService.calculateBasketWeight(basket), 236);
    }

    @Test
    public void testCalculateBasketWeightStream() {
        assertEquals(ballService.calculateBasketWeightStream(basket), 236);
    }

    @Test
    public void testCalculateWeightByColor() {
        assertEquals(ballService.calculateWeightByColor(basket, Color.BLACK), 26);
    }

    @Test
    public void testCalculateWeightByColorStream() {
        assertEquals(ballService.calculateWeightByColorStream(basket, Color.BLACK), 26);
    }

    @Test
    public void testCalculateQuantityOfBallsByColor() {
        assertEquals(ballService.calculateQuantityOfBallsByColor(basket, Color.CYAN), 110);
    }
    @Test
    public void testCalculateQuantityOfBallsByColorStream() {
        assertEquals(ballService.calculateQuantityOfBallsByColorStream(basket, Color.CYAN), 110);
    }

}
