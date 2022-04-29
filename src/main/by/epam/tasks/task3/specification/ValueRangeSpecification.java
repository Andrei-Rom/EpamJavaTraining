package main.by.epam.tasks.task3.specification;

import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.service.CustomizableArrayService;

import java.util.function.Predicate;

public class ValueRangeSpecification  implements Predicate<CustomizableArray> {
    private int minIncluding;
    private int maxExcluding;

    public ValueRangeSpecification(int minIncluding, int maxExcluding) {
        this.minIncluding = minIncluding;
        this.maxExcluding = maxExcluding;
    }

    @Override
    public boolean test(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        int min = service.findMin(array);
        int max = service.findMax(array);

        return minIncluding <= min && max < maxExcluding;
    }
}
