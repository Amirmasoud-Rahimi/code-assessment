package org.multithread;

import java.util.List;

public class Consumer implements Runnable {
    private final List<Integer> integers;

    public Consumer(List<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (integers) {
                while (integers.isEmpty()) {
                    try {
                        integers.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer fetch = integers.remove(0);
                System.out.println("consume -> " + fetch);
            }
        }
    }
}