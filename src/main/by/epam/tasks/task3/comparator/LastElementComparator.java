package main.by.epam.tasks.task3.comparator;

import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.Comparator;

public class LastElementComparator implements Comparator<CustomizableArray> {
    @Override
    public int compare(CustomizableArray o1, CustomizableArray o2) {
        return o1.getElement(o1.getSize()-1) - o2.getElement(o2.getSize()-1);
    }
}
