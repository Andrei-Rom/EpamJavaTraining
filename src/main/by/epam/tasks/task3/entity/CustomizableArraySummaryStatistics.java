package main.by.epam.tasks.task3.entity;

import java.util.StringJoiner;

public class CustomizableArraySummaryStatistics {
    private int min;
    private int max;
    private double average;
    private int sum;

    public CustomizableArraySummaryStatistics() {
    }

    public CustomizableArraySummaryStatistics(int min, int max, int average, int sum) {
        this.min = min;
        this.max = max;
        this.average = average;
        this.sum = sum;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomizableArraySummaryStatistics that = (CustomizableArraySummaryStatistics) o;

        if (min != that.min) return false;
        if (max != that.max) return false;
        if (Double.compare(that.average, average) != 0) return false;
        return sum == that.sum;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = min;
        result = 31 * result + max;
        temp = Double.doubleToLongBits(average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + sum;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomizableArraySummaryStatistics.class.getSimpleName() + "[", "]")
                .add("min=" + min)
                .add("max=" + max)
                .add("average=" + average)
                .add("sum=" + sum)
                .toString();
    }
}
