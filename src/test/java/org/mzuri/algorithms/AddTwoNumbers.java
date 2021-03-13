package org.mzuri.algorithms;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Dummy head is common paradigm to solve linkedlist creation
 */
public class AddTwoNumbers {

    private Logger logger = LoggerFactory.getLogger(AddTwoNumbers.class);

    @Test
    public void test() {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l2.next = l3;
        l1.next = l2;

        ListNode p1 = new ListNode(5);
        ListNode p2 = new ListNode(6);
        ListNode p3 = new ListNode(4);

        p2.next = p3;
        p1.next = p2;

        ListNode result = addTwoNumbers(l1, p1);

        printNode( result );
    }

    private void printNode(ListNode listNode) {

        while(listNode != null) {
            logger.info("val : {}", listNode .val);
            listNode = listNode .next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr = new ListNode( 0 );
        ListNode q = l1, p = l2, dummyHead = curr;

        int carry = 0;

        while( q != null && p != null) {

            int x = q == null ? 0 : q.val;
            int y = p == null ? 0 : p.val;

            int sum = carry + x + y;

            carry = sum / 10;


            curr.next = new ListNode( sum % 10 );

            curr = curr.next;

            q = q.next;
            p = p.next;
        }


        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}