package main.by.epam.tasks.multithreadingexamples.phaserexample;

import java.util.concurrent.Phaser;

public class NewRace {
    private static final Phaser START = new Phaser(8);
    private static final int trackLength = 500000;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i, (int) (Math.random() * 100 + 50))).start();
            Thread.sleep(100);
        }

        while (START.getRegisteredParties() > 3) //Проверяем, собрались ли все автомобили
            Thread.sleep(100);                  //у стартовой прямой. Если нет, ждем 100ms

        Thread.sleep(100);
        System.out.println("Ready!");
        START.arriveAndDeregister();
        Thread.sleep(100);
        System.out.println("Set!");
        START.arriveAndDeregister();
        Thread.sleep(100);
        System.out.println("Go!");
        START.arriveAndDeregister();
    }

    public static class Car implements Runnable {
        private int carNumber;
        private int carSpeed;

        public Car(int carNumber, int carSpeed) {
            this.carNumber = carNumber;
            this.carSpeed = carSpeed;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Car #%d pulled up to the starting line.\n", carNumber);
                START.arriveAndDeregister();
                START.awaitAdvance(0);
                Thread.sleep(trackLength / carSpeed);
                System.out.printf("Car #%d finished!\n", carNumber);
            } catch (InterruptedException e) {
            }
        }
    }
}
