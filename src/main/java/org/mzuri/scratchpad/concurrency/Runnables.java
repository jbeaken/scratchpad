package org.mzuri.scratchpad.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Runnables {

    private static Logger logger = LoggerFactory.getLogger(Runnables.class);

    static Callable<Integer> c1 = new Callable<Integer>() {

        int count = 1;

        @Override
        public Integer call() {
            System.out.println("In call method with thread : " + Thread.currentThread().getName());
            return count++;
        }
    };

    static Callable<Integer> c2 = () -> null;

    static Runnable r1 = new Runnable() {
        @Override
        public void run() {

        }
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(5);

        List<Future> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<Integer> future = executorService.submit(c1);
            futures.add(future);
        }

        for (Future<Integer> f : futures) {
//            while (!f.isDone()) {
//                logger.info("Waiting");
                Integer integer = f.get();
                System.out.println(Thread.currentThread().getName() + " " + integer);
//            }
        }

        executorService.shutdown();

    }
}
