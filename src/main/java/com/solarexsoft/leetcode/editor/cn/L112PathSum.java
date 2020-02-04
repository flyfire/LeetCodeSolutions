//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.Stack;

public class L112PathSum {
    public static void main(String[] args) {
         Solution solution = new L112PathSum().new Solution();
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        treeNodeStack.push(root);
        sumStack.push(sum);

        while (!treeNodeStack.isEmpty()) {
            TreeNode top = treeNodeStack.pop();
            Integer sumTop = sumStack.pop();
            if (top.left == null && top.right == null && top.val == sumTop) return true;
            if (top.left != null) {
                treeNodeStack.push(top.left);
                sumStack.push(sumTop - top.val);
            }
            if (top.right != null) {
                treeNodeStack.push(top.right);
                sumStack.push(sumTop - top.val);
            }
        }
        return false;
    }

    public boolean hasPathSumRecursive(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}