package main.by.epam.tasks.task1.entity;

import java.util.List;
import java.util.StringJoiner;

public class Basket {
    private List<Ball> balls;

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) {
        this.balls = balls;
    }

    public void setBall(Ball ball) {
        this.balls.add(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket1 = (Basket) o;

        return balls != null ? balls.equals(basket1.balls) : basket1.balls == null;
    }

    @Override
    public int hashCode() {
        return balls != null ? balls.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("basket=" + balls)
                .toString();
    }
}
