package org.example;

public class ElapsedTime {
    public static void main(String[] args) {
        Thread displayThread = new Thread(new DisplayElapsedTime());
        Thread messageThread = new Thread(new PrintMessage());

        displayThread.start();
        messageThread.start();
    }

    private static class DisplayElapsedTime implements Runnable {
        @Override
        public void run() {
            long startTime = System.currentTimeMillis();

            while (true) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                int seconds = (int) (elapsedTime / 1000);

                System.out.printf("Минув час: %d секунд%n", seconds);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class PrintMessage implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Пройшло 5 секунд");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}