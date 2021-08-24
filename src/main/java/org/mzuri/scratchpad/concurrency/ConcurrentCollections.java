package org.mzuri.scratchpad.concurrency;

import java.util.Collections;
import java.util.List;

public class ConcurrentCollections {


    public static void main(String[] args) {

        var original = List.of(1,2,3,4,5);

        var copy2 = Collections.synchronizedList(original);
        for(Integer w : copy2)
            copy2.remove(w);

    }
}
