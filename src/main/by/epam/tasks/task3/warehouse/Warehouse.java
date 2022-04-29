package main.by.epam.tasks.task3.warehouse;

import main.by.epam.tasks.task3.entity.CustomizableArraySummaryStatistics;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse instance = new Warehouse();
    private Map<Integer, CustomizableArraySummaryStatistics> ArrayParametersMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public CustomizableArraySummaryStatistics get(Integer key) {
        return ArrayParametersMap.get(key);
    }

    public CustomizableArraySummaryStatistics put(Integer key, CustomizableArraySummaryStatistics value) {
        return ArrayParametersMap.put(key, value);
    }

    public void putAll(Map<? extends Integer, ? extends CustomizableArraySummaryStatistics> m) {
        ArrayParametersMap.putAll(m);
    }

    public CustomizableArraySummaryStatistics remove(Integer key) {
        return ArrayParametersMap.remove(key);
    }
}