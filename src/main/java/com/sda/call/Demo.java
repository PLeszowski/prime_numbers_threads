package com.sda.call;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sda.prime.BasicPrimeFounder;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Task task = new Task(new BasicPrimeFounder(), 2, 100);

        Future<List<Integer>> future = executorService.submit(task);

        System.out.println(future.isDone());
        System.out.println(future.get());
        System.out.println(future.isDone());

    }
}
