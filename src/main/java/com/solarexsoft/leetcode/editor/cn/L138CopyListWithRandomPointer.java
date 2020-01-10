//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。 
//
// 要求返回这个链表的 深拷贝。 
//
// 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示： 
//
// 
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
// Related Topics 哈希表 链表

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;

public class L138CopyListWithRandomPointer {
    public static void main(String[] args) {
         Solution solution = new L138CopyListWithRandomPointer().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node copyHead = new Node(head.val);
        HashMap<Node, Node> newOldNodeMap = new HashMap<>();
        Node p = head;
        Node q = copyHead;
        newOldNodeMap.put(head, copyHead);
        while (p.next != null) {
            Node tmp = p.next;
            Node copyTmp = new Node(tmp.val);
            q.next = copyTmp;
            newOldNodeMap.put(tmp, copyTmp);
            q = q.next;
            p = p.next;
        }
        p = head;
        q = copyHead;
        if (head.random == null) {
            copyHead.random = null;
        } else {
            copyHead.random = newOldNodeMap.get(head.random);
        }

        while (p.next != null) {
            if (p.next.random == null) {
                q.next.random = null;
            } else {
                q.next.random = newOldNodeMap.get(p.next.random);
            }
            p = p.next;
            q = q.next;
        }
        return copyHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}