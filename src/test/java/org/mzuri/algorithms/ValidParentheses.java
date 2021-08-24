package org.mzuri.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;

public class ValidParentheses {
    @Test
    public void test() {

        String s1 = "[{}]";
        String s2 = "[";
        String s3 = "]";

        Assert.assertTrue( isValidWithStack(s1) );

        Assert.assertFalse( isValidWithStack(s2) );

        Assert.assertFalse( isValidWithStack(s3) );
    }

    public boolean isValidWithStack(String s) {


        if (s.isEmpty()) return true;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push( c );
            }

            if (c == ')') {
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }
            if (c == '}') {
                if(stack.isEmpty() || stack.pop() != '{') return false;
            }
            if (c == ']') {
                if(stack.isEmpty() || stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
