package org.mzuri.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class ZigZagConversion {

    @Test
    public void test() {


        Assert.assertEquals( convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR");

        Assert.assertEquals( convert("AB", 1), "AB");

    }

    public String convert(String s, int numRows) {

        if(numRows == 1) return s;

        StringBuilder[] sbArray = new StringBuilder[ numRows ];

        for(int i = 0; i < numRows; i++) {
            sbArray[i] = new StringBuilder();
        }

        int row = 0;
        boolean desc = false;

        for (char c : s.toCharArray()) {

            sbArray[ row ].append( c );

            if( row == numRows -1 || row == 0) desc = !desc;

            row += desc ? 1 : -1;
        }

        StringBuilder f = new StringBuilder();

        for(StringBuilder sb : sbArray) {
            f.append( sb.toString() );
        }

        return f.toString();
    }
}
