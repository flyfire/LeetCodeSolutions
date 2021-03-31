//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 166 👎 0

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L100294LianBiaoZhongDaoShuDiKgeJieDianLcof {
    public static void main(String[] args) {
         Solution solution = new L100294LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = null;
        ListNode kth = solution.getKthFromEnd(node0, 0);
        System.out.println(kth);
        kth = solution.getKthFromEnd(node0, 1);
        System.out.println(kth);
        kth = solution.getKthFromEnd(node0, 10);
        if (kth != null) {
            System.out.println(kth);
        } else {
            System.out.println("null");
        }
        node0.next = null;
        kth = solution.getKthFromEnd(node0, 1);
        if (kth != null) {
            System.out.println(kth);
        } else {
            System.out.println("null");
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head, q = head;
        while (k > 0 && q != null) {
            q = q.next;
            k--;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}