package by.epam.tasks.task2.entity;

import java.util.List;
import java.util.StringJoiner;

public class Basket {
    private List<Ball> basket;

    public List<Ball> getBasket() {
        return basket;
    }

    public void setBasket(List<Ball> basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("basket=" + basket)
                .toString();
    }
}
