package main.by.epam.tasks.task3.specification;


import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.service.CustomizableArrayService;

import java.util.function.Predicate;

public class AverageSpecification implements Predicate<CustomizableArray> {
    private int averageFromIncluding;
    private int averageToExcluding;

    public AverageSpecification(int averageValue) {
        this.averageFromIncluding = averageValue;
        this.averageToExcluding = averageValue + 1;
    }

    public AverageSpecification(int fromIncluding, int toExcluding) {
        this.averageFromIncluding = fromIncluding;
        this.averageToExcluding = toExcluding;
    }

    public AverageSpecification(int averageValueIncluding, boolean isFrom) {
        if (isFrom) {
            this.averageFromIncluding = averageValueIncluding;
            this.averageToExcluding = Integer.MAX_VALUE;
        } else {
            this.averageFromIncluding = Integer.MIN_VALUE;
            this.averageToExcluding = averageValueIncluding + 1;
        }
    }

    @Override
    public boolean test(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        double average = service.findAverage(array);
        return averageFromIncluding <= average && average < averageToExcluding;
    }
}
