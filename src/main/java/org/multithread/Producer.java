package org.multithread;

import java.util.List;

public class Producer implements Runnable {
    private final List<Integer> integers;

    public Producer(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (integers) {
                Integer num = (int) (Math.random() * 1000);
                System.out.println("produce -> " + num);
                integers.add(num);
                integers.notify();
            }
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}