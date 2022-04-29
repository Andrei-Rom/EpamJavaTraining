package main.by.epam.tasks.task3.comparator;

import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.Comparator;

public class IdComparator implements Comparator<CustomizableArray> {
    @Override
    public int compare(CustomizableArray o1, CustomizableArray o2) {
        return o1.getId() - o2.getId();
    }
}
