//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L21MergeTwoSortedLists {
    public static void main(String[] args) {
         Solution solution = new L21MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            int l1Val = l1.val;
            int l2Val = l2.val;
            if (l1Val < l2Val) {
                p.next = new ListNode(l1Val);
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2Val);
                p = p.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            p.next = new ListNode(l1.val);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}