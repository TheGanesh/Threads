package com.ganesh.threads.Volatile;

/**
 * Created by Ganesh on 1/13/15.
 */
public class Counter {

    private volatile int counter;

    public Counter(int counter){
        this.counter=counter;
    }

    public void increment(){
        this.counter++;
    }
    public void decrement(){
        this.counter--;
    }
    public int getCount(){
        System.out.println(Thread.currentThread().getName()+":count:"+this.counter);
        return counter;
    }
}
