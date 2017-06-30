package com.sda.prime;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws InterruptedException, IOException {

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

        List<Integer> result = new ArrayList<>();

        result.addAll(first.getPrimeList());
        result.addAll(second.getPrimeList());
        result.addAll(third.getPrimeList());
        result.addAll(fourth.getPrimeList());
        result.addAll(fifth.getPrimeList());

        PrintWriter printWriter = new PrintWriter(new FileWriter("primes.txt"));

        for(Integer item: result){
            printWriter.print(item + ", ");
        }

        printWriter.close();



    }
}
