package main.by.epam.tasks.task3.repository;

import main.by.epam.tasks.task3.sorting.SortingService;
import main.by.epam.tasks.task3.entity.CustomizableArray;

import java.util.List;
import java.util.function.Predicate;

public interface Repository {
    void add(CustomizableArray array);
    void remove(int id);
    List<CustomizableArray> query(Predicate<CustomizableArray> predicate);
    void sort(SortingService sortingService);
}
