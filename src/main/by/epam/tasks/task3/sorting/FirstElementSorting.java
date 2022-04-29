package main.by.epam.tasks.task3.sorting;

import main.by.epam.tasks.task3.comparator.FirstElementComparator;
import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.Comparator;
import java.util.List;

public class FirstElementSorting implements SortingService {
    @Override
    public void sort(List<CustomizableArray> list) {
        Comparator<CustomizableArray> comparator = new FirstElementComparator();
        list.sort(comparator);
    }
}
