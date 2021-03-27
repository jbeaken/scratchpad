package org.mzuri.algorithms.amazon;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class AmazonDistance {

    //3, 3, [[1, 0, 0], [1, 0, 0], [1, 9, 1]]


      private List<List<Integer>> area;


      @Test
       public void test1() {

           List<Integer> row1 = Arrays.asList(1, 0, 0);
           List<Integer> row2 = Arrays.asList(1, 0, 0);
           List<Integer> row3 = Arrays.asList(1, 9, 1);

           area = Arrays.asList(row1, row2, row3);

           int totalNoOfMoves = move(0, 0, 0);

           log.info("Have no of moves {}", totalNoOfMoves);

           Assert.assertEquals(totalNoOfMoves, 3);
        }

    @Test
    public void thisIsATest() {

    }

    @Test
    public void test2() {

        List<Integer> row1 = Arrays.asList(1, 0, 0);
        List<Integer> row2 = Arrays.asList(1, 0, 0);
        List<Integer> row3 = Arrays.asList(1, 1, 0);
        List<Integer> row4 = Arrays.asList(0, 1, 0);
        List<Integer> row5 = Arrays.asList(1, 1, 0);
        List<Integer> row6 = Arrays.asList(1, 9, 0);

        area = Arrays.asList(row1, row2, row3, row4, row5, row6);

        int totalNoOfMoves = move(0, 0, 0);

        log.info("Have no of moves {}", totalNoOfMoves);

        Assert.assertEquals(totalNoOfMoves, 6);
    }


    private int move(int x, int y, int noOfMoves) {

           if(getVal( x, y ) == 9) return noOfMoves * 100;

           int leftMove = -1, rightMove = -1, upMove = -1, downMove = -1;

//           if( canMove( x - 1, y) ) leftMove = move( x - 1, y, noOfMoves);

            if( canMove( x + 1, y) ) rightMove = move( x + 1, y, noOfMoves + 1);

//            if( canMove( x, y - 1) ) upMove = move( x , y - 1, noOfMoves);

            if( canMove( x, y + 1) ) downMove = move( x, y + 1, noOfMoves + 1);

            int result =  Math.max( Math.max( leftMove, rightMove) , Math.max( upMove, downMove) );

            return Math.max( result, noOfMoves);

       }

    private boolean canMove(int x, int y) {

           if( x < 0 || x == area.get( 0 ).size()) return false;

        if( y < 0 || y == area.size()) return false;

        if( getVal(x, y ) == 0) return false;

        return true;
    }

    private int getVal(int x, int y) {

           int val = area.get( y ).get( x );

           return val;
    }



}
