package com.solarexsoft.leetsolutions;

/**
 * Created by houruhou on 2018/8/15.
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2;
        ListNode pivot = result;
        int carray = 0;
        while (p != null || q != null) {
            int pVal = p != null ? p.val : 0;
            int qVal = q != null ? q.val : 0;

            int sum = pVal + qVal + carray;
            int resultVal = sum%10;
            carray = sum / 10;
            ListNode tmp = new ListNode(resultVal);
            pivot.next = tmp;
            pivot = tmp;

            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            if (p == null && q == null && carray != 0) {
                ListNode end = new ListNode(carray);
                pivot.next = end;
            }
        }
        return result.next;
    }

    public static void printListNode(ListNode node){
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode a0 = new ListNode(3);
        ListNode a1 = new ListNode(7);
        a0.next = a1;

        ListNode b0 = new ListNode(8);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(2);
        b0.next = b1;
        b1.next = b2;

        ListNode result = addTwoNumbers(a0, b0);
        printListNode(result);

    }
}
