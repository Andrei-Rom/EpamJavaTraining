package main.by.epam.tasks.task3.specification;

import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.service.CustomizableArrayService;

import java.util.function.Predicate;

public class MinSpecification implements Predicate<CustomizableArray> {
    private int minFromIncluding;
    private int minToExcluding;

    public MinSpecification(int minValue) {
        this.minFromIncluding = minValue;
        this.minToExcluding = minValue + 1;
    }

    public MinSpecification(int minFromIncluding, int minToExcluding) {
        this.minFromIncluding = minFromIncluding;
        this.minToExcluding = minToExcluding;
    }

    public MinSpecification(int minValueIncluding, boolean isFrom) {
        if (isFrom) {
            this.minFromIncluding = minValueIncluding;
            this.minToExcluding = Integer.MAX_VALUE;
        } else {
            this.minFromIncluding = Integer.MIN_VALUE;
            this.minToExcluding = minValueIncluding + 1;
        }
    }

    public boolean test(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        int max = service.findMax(array);
        return minFromIncluding <= max && max < minToExcluding;
    }
}