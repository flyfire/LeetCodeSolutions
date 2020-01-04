//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.*;

public class L102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
         Solution solution = new L102BinaryTreeLevelOrderTraversal().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode head = deque.remove();
                currentLevel.add(head.val);
                if (head.left != null) {
                    deque.add(head.left);
                }
                if (head.right != null) {
                    deque.add(head.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}