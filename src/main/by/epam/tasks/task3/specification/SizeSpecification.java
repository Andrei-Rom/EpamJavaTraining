package main.by.epam.tasks.task3.specification;

import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.service.CustomizableArrayService;

import java.util.function.Predicate;

public class SizeSpecification implements Predicate<CustomizableArray> {
    private int fromSizeIncluding;
    private int toSizeExcluding;

    public SizeSpecification(int size) {
        this.fromSizeIncluding = size;
        this.toSizeExcluding = size + 1;
    }

    public SizeSpecification(int fromSizeIncluding, int toSizeExcluding) {
        this.fromSizeIncluding = fromSizeIncluding;
        this.toSizeExcluding = toSizeExcluding;
    }

    public SizeSpecification(int sizeIncluding, boolean isFrom) {
        if (isFrom) {
            this.fromSizeIncluding = sizeIncluding;
            this.toSizeExcluding = Integer.MAX_VALUE;
        } else {
            this.fromSizeIncluding = Integer.MIN_VALUE;
            this.toSizeExcluding = sizeIncluding + 1;
        }
    }

    public boolean test(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        int size = array.getSize();
        return fromSizeIncluding <= size && size < toSizeExcluding;
    }
}