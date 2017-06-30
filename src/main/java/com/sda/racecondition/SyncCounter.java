package com.sda.racecondition;

public class SyncCounter implements Counter {

    private int counter;

    public SyncCounter() {
        counter = 0;
    }

    @Override
    public synchronized void increment() {
        counter++;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
