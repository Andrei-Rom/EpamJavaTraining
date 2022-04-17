package by.epam.tasks.task2.entity;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int[] EMPTY_ARRAY = {};
    private static final int[] DEFAULTCAPACITY_EMPTY_ARRAY = {};
    private int[] array;
    private int size;

    public CustomArray() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomArray(int[] array) {
        this.array = array;
        this.size = array.length;
    }

    public CustomArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.array = new int[initialCapacity];
        } else if (initialCapacity == 0) {
            this.array = EMPTY_ARRAY;
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
    }

    public int getSize() {
        return size;
    }

    public void add(int e) {
        add(e, array, size);
    }

    private void add(int e, int[] array, int s) {
        if (s == array.length)
            array = grow();
        array[s] = e;
        size = s + 1;
    }

    private int[] grow() {
        return grow(size + 1);
    }

    private int[] grow(int minCapacity) {
        int oldCapacity = array.length;
        if (oldCapacity > 0 || array != DEFAULTCAPACITY_EMPTY_ARRAY) {
            int newCapacity = CustomArray.newLength(oldCapacity,
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomArray that = (CustomArray) o;

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomArray.class.getSimpleName() + "[", "]")
                .add("array=" + Arrays.toString(array))
                .toString();
    }
}
