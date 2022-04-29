package main.by.epam.tasks.task3.sorting;

import main.by.epam.tasks.task3.comparator.IdComparator;
import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.Comparator;
import java.util.List;

public class IdSorting implements SortingService {
    @Override
    public void sort(List<CustomizableArray> list) {
        Comparator<CustomizableArray> comparator = new IdComparator();
        list.sort(comparator);
    }
}
