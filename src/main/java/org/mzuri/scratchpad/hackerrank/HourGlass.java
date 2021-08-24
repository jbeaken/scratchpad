package org.mzuri.scratchpad.hackerrank;
import java.io.*;


public class HourGlass {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        int length = arr[0].length;
        int depth = arr.length;

        for(int i = 0; i <= length - 3; i++) {
            for(int j = 0; j <= depth - 3; j++) {
                System.out.println(i + " " + j);
                max = Math.max(max, sumHourGlass(i, j, arr));
            }
        }

        return max;
    }

    private static int sumHourGlass(int x, int y, int[][]arr) {
return 1;
//        return arr[y][x] + arr[y][x+1] + arr[y][x+2] + arr[y + 1][x+1]
//                + arr[y + 2][x] + arr[y + 2][x+1] + arr[y + 2][x + 2];
    }


    public static void main(String[] args) throws IOException {

        int[][] arr = new int[6][6];



        int result = hourglassSum(arr);

    }
}
