package main.by.epam.tasks.task3.specification;

import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.service.CustomizableArrayService;

import java.util.function.Predicate;

public class MaxSpecification implements Predicate<CustomizableArray> {
    private int maxFromIncluding;
    private int maxToExcluding;

    public MaxSpecification(int maxValue) {
        this.maxFromIncluding = maxValue;
        this.maxToExcluding = maxValue + 1;
    }


    public MaxSpecification(int maxFromIncluding, int maxToExcluding) {
        this.maxFromIncluding = maxFromIncluding;
        this.maxToExcluding = maxToExcluding;
    }

    public MaxSpecification(int maxValueIncluding, boolean isFrom) {
        if (isFrom) {
            this.maxFromIncluding = maxValueIncluding;
            this.maxToExcluding = Integer.MAX_VALUE;
        } else {
            this.maxFromIncluding = Integer.MIN_VALUE;
            this.maxToExcluding = maxValueIncluding + 1;
        }
    }

    public boolean test(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        int max = service.findMax(array);
        return maxFromIncluding <= max && max < maxToExcluding;
    }
}