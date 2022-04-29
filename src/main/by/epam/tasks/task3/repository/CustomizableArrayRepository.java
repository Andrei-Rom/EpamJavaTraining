package main.by.epam.tasks.task3.repository;

import main.by.epam.tasks.task2.entity.CustomArray;
import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.sorting.SortingService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CustomizableArrayRepository {
    private static final CustomizableArrayRepository instance = new CustomizableArrayRepository();
    private List<CustomizableArray> repository;

    private CustomizableArrayRepository(){
    }

    public void add(CustomizableArray array) {
        addToWarehouse(array);
        repository.add(array);
    }

    private void addToWarehouse(CustomizableArray array) {
        ///TO DO
    }

    public void sort(SortingService sortingService) {
        sortingService.sort(repository);
    }

    public List<CustomizableArray> query(Predicate<CustomizableArray> predicate) {
        return repository.stream().filter(predicate).toList();
    }

    public static CustomizableArrayRepository getInstance() {
        return instance;
    }

    public List<CustomizableArray> getRepository() {
        return repository;
    }

    public void setRepository(List<CustomizableArray> repository) {
        this.repository = repository;
    }

    public CustomizableArrayRepository(List<CustomizableArray> repository) {
        this.repository = repository;
    }


}
