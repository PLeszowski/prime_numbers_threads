package com.sda.call;

import java.util.List;
import java.util.concurrent.Callable;

import com.sda.prime.PrimeFounder;

public class Task implements Callable<List<Integer>> {

    private PrimeFounder primeFounder;
    private int from;
    private int to;

    public Task(PrimeFounder primeFounder, int from, int to) {
        this.primeFounder = primeFounder;
        this.from = from;
        this.to = to;
    }

    @Override
    public List<Integer> call() throws Exception {
        return primeFounder.find(from, to);
    }
}
