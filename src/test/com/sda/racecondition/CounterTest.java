package com.sda.racecondition;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CounterTest {

    private Counter counter;

    @Before
    public void setUp() {
        counter = new UnsafeCounter();
    }

    @Test
    public void testCountToThree() {

        counter.increment();
        counter.increment();
        counter.increment();

        Assert.assertEquals(3, counter.getCounter());
    }

    @Test
    public void shouldReturn300WhenRunMultiThread() throws InterruptedException {

       // Runnable increment = new Task(counter,100);
        Runnable increment = ()->{
            for(int i = 0;i<100;++i){
                counter.increment();
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread first = new Thread(increment);
        Thread second = new Thread(increment);
        Thread third = new Thread(increment);

        long startTime = System.currentTimeMillis();
        first.start();
        second.start();
        third.start();

        first.join();
        second.join();
        third.join();
        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime -startTime + " ms");

        Assert.assertEquals(300,counter.getCounter());
    }

  private static class Task implements Runnable {

        private Counter counter;
        private int iterationNumber;

        public Task(Counter counter, int iterationNumber) {
            this.counter = counter;
            this.iterationNumber = iterationNumber;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterationNumber; ++i) {
                counter.increment();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}