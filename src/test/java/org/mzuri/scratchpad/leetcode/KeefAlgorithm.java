package org.mzuri.scratchpad.leetcode;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;


@Data
class KeefItem implements Comparable {
    private final boolean isStart;
    private final int value;

    @Override
    public int compareTo(Object o) {
        KeefItem other = (KeefItem) o;

        if (other.getValue() != this.getValue()) {
            return this.getValue() - other.getValue();
        }

        if (this.isStart == true) return -1;

        return 1;
    }
}

public class KeefAlgorithm {

    List<KeefItem> keefItemList = new ArrayList<>();

    int counter = 0, max = 0, previous = 0;

    @Test
    void test() {
        buildKeeflist(new int[][]{{1,4}, {3,9}, {9,12}} );

//        buildKeefList(List.of(List.of(1, 4), List.of(3, 9), List.of(9, 12)));
//        buildKeefList(List.of(List.of(5, 8), List.of(2, 6), List.of(9, 12)));

        keefItemList.stream().forEach(getMaxConsumer());

        System.out.println(max);
    }



    private Consumer<KeefItem> getMaxConsumer() {
        return e -> {
            if (e.isStart() == true) {
                if (counter == 0) {
                    previous = e.getValue();
                }
                counter++;
            } else {
                counter--;
                if (counter == 0) {
                    max = Math.max(e.getValue() - previous, max);
                }
            }
        };
    }

    private void buildKeeflist(int[][] ints) {

        for(int[] i: ints) {
            keefItemList.add(new KeefItem(true, i[0]));
            keefItemList.add(new KeefItem(false, i[1]));
        }
    }

    private void buildKeefList(List<List<Integer>> list) {

        list.forEach(element -> {
            keefItemList.add(new KeefItem(true, element.get(0)));
            keefItemList.add(new KeefItem(false, element.get(1)));
        });

        Collections.sort(keefItemList);
    }
}
