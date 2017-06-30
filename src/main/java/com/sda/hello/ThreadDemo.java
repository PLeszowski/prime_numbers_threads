package com.sda.hello;

import org.omg.PortableServer.THREAD_POLICY_ID;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().isDaemon());

        Runnable runnable = new Task();

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(20);
      //  thread.join();

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            while (true)
            System.out.printf("%s %s\n", Thread.currentThread().getName(),Thread.currentThread().isDaemon());
        }
    }
}
