package com.fit.multithreading;

import java.util.Random;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        // Java's Callable class function demo.
        // Unlike a Runnable Thread, Callable returns a value.
        // To use Callable class, you need to implement call() function - where as it is run method for Runnable class.
        // Callable needs to be submitted to Executor service to run.

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                return random.nextInt(10000);
            }
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}


