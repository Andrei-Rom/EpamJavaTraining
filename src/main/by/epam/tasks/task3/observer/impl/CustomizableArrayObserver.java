package main.by.epam.tasks.task3.observer.impl;

import main.by.epam.tasks.task3.entity.CustomizableArray;
import main.by.epam.tasks.task3.entity.CustomizableArraySummaryStatistics;
import main.by.epam.tasks.task3.observer.ArrayObserver;
import main.by.epam.tasks.task3.service.CustomizableArrayService;
import main.by.epam.tasks.task3.warehouse.Warehouse;

public class CustomizableArrayObserver implements ArrayObserver {
    @Override
    public void actionPerformed(CustomizableArray array) {
        CustomizableArrayService service = new CustomizableArrayService();
        int id = array.getId();
        int min = service.findMin(array);
        int max = service.findMax(array);
        double average = service.findAverage(array);
        int sum = service.findSum(array);

        CustomizableArraySummaryStatistics statistics = new CustomizableArraySummaryStatistics();
        statistics.setMin(min);
        statistics.setMax(max);
        statistics.setAverage(average);
        statistics.setSum(sum);

        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, statistics);
    }
}
