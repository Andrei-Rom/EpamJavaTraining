package main.by.epam.tasks.task3.repository;

import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.entity.CustomizableArraySummaryStatistics;
import main.by.epam.tasks.task3.service.CustomizableArrayService;
import main.by.epam.tasks.task3.sorting.SortingService;
import main.by.epam.tasks.task3.warehouse.Warehouse;

import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomizableArrayRepository implements Repository {
    private static final CustomizableArrayRepository instance = new CustomizableArrayRepository();
    private List<CustomizableArray> repository;

    private CustomizableArrayRepository() {
    }

    @Override
    public void add(CustomizableArray array) {
        addToWarehouse(array);
        repository.add(array);
    }

    private void addToWarehouse(CustomizableArray array) {
        Warehouse warehouse = Warehouse.getInstance();
        CustomizableArrayService service = new CustomizableArrayService();
        int min = service.findMin(array);
        int max = service.findMax(array);
        double average = service.findAverage(array);
        int sum = service.findSum(array);
        CustomizableArraySummaryStatistics statistics = new CustomizableArraySummaryStatistics(min, max, average, sum);
        warehouse.put(array.getId(), statistics);
    }

    @Override
    public void remove(int id) {
        repository.removeIf(array -> array.getId() == id);
    }

    @Override
    public void sort(SortingService sortingService) {
        sortingService.sort(repository);
    }

    @Override
    public List<CustomizableArray> query(Predicate<CustomizableArray> predicate) {
        return repository.stream().filter(predicate).collect(Collectors.toList());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomizableArrayRepository that = (CustomizableArrayRepository) o;

        return repository != null ? repository.equals(that.repository) : that.repository == null;
    }

    @Override
    public int hashCode() {
        return repository != null ? repository.hashCode() : 0;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomizableArrayRepository.class.getSimpleName() + "[", "]")
                .add("repository=" + repository)
                .toString();
    }
}
