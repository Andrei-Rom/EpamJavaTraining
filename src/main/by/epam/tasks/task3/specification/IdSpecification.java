package main.by.epam.tasks.task3.specification;

import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.function.Predicate;

public class IdSpecification implements Predicate<CustomizableArray> {
    private int idFromIncluding;
    private int idToExcluding;

    public IdSpecification(int id) {
        this.idFromIncluding = id;
        this.idToExcluding = id + 1;
    }

    public IdSpecification(int idFromIncluding, int idToExcluding) {
        this.idFromIncluding = idFromIncluding;
        this.idToExcluding = idToExcluding;
    }

    public IdSpecification(int idValueIncluding, boolean isFrom) {
        if (isFrom) {
            this.idFromIncluding = idValueIncluding;
            this.idToExcluding = Integer.MAX_VALUE;
        } else {
            this.idFromIncluding = Integer.MIN_VALUE;
            this.idToExcluding = idValueIncluding + 1;
        }

    }

    @Override
    public boolean test(CustomizableArray array) {
        int id = array.getId();
        return idFromIncluding <= id && id < idToExcluding;
    }
}
