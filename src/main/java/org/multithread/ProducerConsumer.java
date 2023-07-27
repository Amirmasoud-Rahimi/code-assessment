package org.multithread;

import org.multithread.Consumer;
import org.multithread.Producer;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new LinkedList<>();
        Thread[] threads = {new Thread(new Producer(list)),new Thread(new Producer(list)),
                new Thread(new Consumer(list)),new Thread(new Consumer(list))};
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Finish. List.Size=" + list.size());
    }
}