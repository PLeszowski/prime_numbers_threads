package com.sda.prime;

public class Demo {

    public static void main(String[] args) throws InterruptedException {

        PrimeFounder primeFounder = new BasicPrimeFounder();

        PrimeFounderTask first = new PrimeFounderTask(primeFounder, 2, 200_000);
        PrimeFounderTask second = new PrimeFounderTask(primeFounder, 200_001, 400_000);
        PrimeFounderTask third = new PrimeFounderTask(primeFounder, 400_001, 600_000);
        PrimeFounderTask fourth = new PrimeFounderTask(primeFounder, 600_001, 800_000);
        PrimeFounderTask fifth = new PrimeFounderTask(primeFounder, 800_001, 1_000_000);

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);
        Thread thirdThread = new Thread(third);
        Thread fourthThread = new Thread(fourth);
        Thread fifthThread = new Thread(fifth);

        long startTime = System.currentTimeMillis();
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
        fifthThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();
        fourthThread.join();
        fifthThread.join();

        long stopTime = System.currentTimeMillis();

        System.out.println(stopTime - startTime + "ms");
    }
}
