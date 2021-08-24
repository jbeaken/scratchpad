package org.mzuri.scratchpad.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class Coin {

    private AtomicBoolean coin = new AtomicBoolean(false);

    void flip() {
        coin.getAndSet(!coin.get());
    }

    public static void main(String[] gamble) throws Exception {
        var coin = new Coin();

        ExecutorService s = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++) {
            s.execute(() -> coin.flip());
        }

        s.shutdown();

        Thread.sleep(5000);

        System.out.println(coin.coin.get());
    }
}
