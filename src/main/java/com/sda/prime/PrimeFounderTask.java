package com.sda.prime;

import java.util.List;

public class PrimeFounderTask implements Runnable {

    private List<Integer> primeList;
    private PrimeFounder primeFounder;
    private int from;
    private int to;

    public PrimeFounderTask(PrimeFounder primeFounder, int from, int to) {
        this.primeFounder = primeFounder;
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {


    /*    try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        primeList = primeFounder.find(from, to);
    }

    public List<Integer> getPrimeList() {
        return primeList;
    }
}
