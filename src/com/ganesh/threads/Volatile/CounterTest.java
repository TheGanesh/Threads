package com.ganesh.threads.Volatile;

/**
 * Created by Ganesh on 1/13/15.
 */
public class CounterTest {

    public static void main(String[] args) throws InterruptedException {

       final Counter counter = new Counter(0);

        Thread thread1 = new Thread("WriteThread") {
            @Override
            public void run() {

                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread2 = new Thread("ReadThread") {
            @Override
            public void run() {
                counter.getCount();
            }
        };

        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();
    }
}
