package main.by.epam.tasks.task3.entity;

import main.by.epam.tasks.task2.util.creator.CustomArrayCreator;
import main.by.epam.tasks.task3.observer.ArrayObserver;
import main.by.epam.tasks.task3.observer.Observable;
import main.by.epam.tasks.task3.observer.impl.CustomizableArrayObserver;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomizableArray implements Observable {
    private int[] array;
    private final int id;
    private int size;
    private ArrayObserver observer = new CustomizableArrayObserver();
    private static int ARRAYS_COUNT;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int[] EMPTY_ARRAY = {};

    public CustomizableArray() {
        this.id = ++ARRAYS_COUNT;
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomizableArray(int[] array) {
        this.id = ++ARRAYS_COUNT;
        this.array = array;
        size = array.length;
    }

    public CustomizableArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.id = ++ARRAYS_COUNT;
            this.array = new int[initialCapacity];
            size = 0;
        } else if (initialCapacity == 0) {
            this.id = ++ARRAYS_COUNT;
            this.array = EMPTY_ARRAY;
            size = 0;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public int[] getArray() {
        if (size < array.length) {
            array = (size == 0)
                    ? EMPTY_ARRAY
                    : Arrays.copyOf(array, size);
        }
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
        size = array.length;
        notifyObservers();
    }

    public int getSize() {
        return size;
    }

    public int getId() {
        return id;
    }

    public int getElement(int index) {
        return array[index];
    }

    public void setElement (int index, int element) {
        if (index < size) {
            array[index] = element;
            notifyObservers();
        }
    }

    public void add(int e) {
        add(e, array, size);
        notifyObservers();
    }

    private void add(int element, int[] array, int size) {
        if (size == array.length) {
            array = grow();
        }
        array[size] = element;
        this.size = size + 1;
    }

    private int[] grow() {
        return grow(size + 1);
    }

    private int[] grow(int minCapacity) {
        int oldCapacity = array.length;
        if (oldCapacity > 0 || array != EMPTY_ARRAY) {
            int newCapacity = newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return array = Arrays.copyOf(array, newCapacity);
        } else {
            return array = new int[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
        if (0 < prefLength && prefLength <= Integer.MAX_VALUE - 8) {
            return prefLength;
        } else {
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) { // overflow
            throw new OutOfMemoryError(
                    "Required array length " + oldLength + " + " + minGrowth + " is too large");
        } else if (minLength <= Integer.MAX_VALUE - 8) {
            return Integer.MAX_VALUE - 8;
        } else {
            return minLength;
        }
    }

    @Override
    public void attach(ArrayObserver observer) {

    }

    @Override
    public void detach(ArrayObserver observer) {

    }

    @Override
    public void notifyObservers() {
        observer.actionPerformed(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomizableArray that = (CustomizableArray) o;

        if (size != that.size) return false;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomizableArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .add("size=" + size)
                .toString();
    }
}

