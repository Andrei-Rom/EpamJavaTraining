package main.by.epam.tasks.task3.observer;

public interface Observable {
    void attach(ArrayObserver observer);
    void detach(ArrayObserver observer);
    void notifyObservers();
}
