package org.mzuri.scratchpad.concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

        private void await(CyclicBarrier c) {
            try {
                System.out.println(Thread.currentThread().getName() + " is calling await");
                c.await();
            } catch (Exception e) {
            }
        }

        public void march(CyclicBarrier c) {
            var s = Executors.newFixedThreadPool(4);
//            var s = Executors.newCachedThreadPool();
//            var s = Executors.newCachedThreadPool();
            for (int i = 0; i < 12; i++)
                s.execute(() -> await(c));
            s.shutdown();
        }

        public static void main(String... strings) {
            new CyclicBarrierExample().march(new CyclicBarrier(4, () -> System.out.println("Ready")));
        }
    }

