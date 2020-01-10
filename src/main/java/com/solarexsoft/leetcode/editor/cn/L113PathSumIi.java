//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。 
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
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
// 
// Related Topics 树 深度优先搜索

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class L113PathSumIi {
    public static void main(String[] args) {
         Solution solution = new L113PathSumIi().new Solution();
         TreeNode t5 = new TreeNode(5);
         TreeNode t4 = new TreeNode(4);
         TreeNode t8 = new TreeNode(8);
         TreeNode t11 = new TreeNode(11);
         TreeNode t13 = new TreeNode(13);
         TreeNode t4t = new TreeNode(4);
         TreeNode t7 = new TreeNode(7);
         TreeNode t2 = new TreeNode(2);
         TreeNode t5t = new TreeNode(5);
         TreeNode t1 = new TreeNode(1);
         t5.left = t4;
         t5.right = t8;
         t4.left = t11;
         t8.left = t13;
         t8.right = t4t;
         t11.left = t7;
         t11.right = t2;
         t4t.left = t5t;
         t4t.right = t1;
         List<List<Integer>> result = solution.pathSum(t5, 22);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> inner = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root, sum, inner, result);
        return result;
    }

    public void pathSumHelper(TreeNode root, int sum, List<Integer> inner, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        inner.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(inner));
        } else {
            sum-=root.val;
            if (root.left != null) {
                pathSumHelper(root.left, sum, inner, result);
            }
            if (root.right != null) {
                pathSumHelper(root.right, sum, inner, result);
            }
        }
        inner.remove(inner.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}