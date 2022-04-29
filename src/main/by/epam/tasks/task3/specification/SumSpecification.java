package main.by.epam.tasks.task3.specification;


import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.service.CustomizableArrayService;

import java.util.function.Predicate;

public class SumSpecification implements Predicate<CustomizableArray> {
    private int sumFromIncluding;
    private int sumToExcluding;

    public SumSpecification(int sumValue) {
        this.sumFromIncluding = sumValue;
        this.sumToExcluding = sumValue + 1;
    }

    public SumSpecification(int fromIncluding, int toExcluding) {
        this.sumFromIncluding = fromIncluding;
        this.sumToExcluding = toExcluding;
    }

    public SumSpecification(int sumValueIncluding, boolean isFrom) {
        if (isFrom) {
            this.sumFromIncluding = sumValueIncluding;
            this.sumToExcluding = Integer.MAX_VALUE;
        } else {
            this.sumFromIncluding = Integer.MIN_VALUE;
            this.sumToExcluding = sumValueIncluding + 1;
        }
    }

    @Override
    public boolean test(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        int sum = service.findSum(array);
        return sumFromIncluding <= sum && sum < sumToExcluding;
    }
}
