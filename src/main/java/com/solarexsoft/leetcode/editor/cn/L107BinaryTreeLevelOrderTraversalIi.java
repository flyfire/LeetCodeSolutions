//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
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

public class L107BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
         Solution solution = new L107BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> levelResult = new ArrayList<>();
                for (int i = 0; i < len; i++) {
                    TreeNode remove = queue.remove();
                    levelResult.add(remove.val);
                    if (remove.left != null) {
                        queue.add(remove.left);
                    }
                    if (remove.right != null) {
                        queue.add(remove.right);
                    }
                }
                result.add(levelResult);
            }
            Collections.reverse(result);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}