//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看
//做它自身的一棵子树。 
//
// 示例 1: 
//给定的树 s: 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
// 
//
// 给定的树 t： 
//
// 
//   4 
//  / \
// 1   2
// 
//
// 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。 
//
// 示例 2: 
//给定的树 s： 
//
// 
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
// 
//
// 给定的树 t： 
//
// 
//   4
//  / \
// 1   2
// 
//
// 返回 false。 
// Related Topics 树

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class L572SubtreeOfAnotherTree {
    public static void main(String[] args) {
         Solution solution = new L572SubtreeOfAnotherTree().new Solution();
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
    private Map<TreeNode, Integer> map = new HashMap<>();

    private String computeHash(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = computeHash(root.left);
        String right = computeHash(root.right);
        String hash = left + root.val + right;
        map.put(root, hash.hashCode());
        return hash;
    }

    private boolean isSub(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        return map.get(s).equals(map.get(t)) || isSub(s.left, t) || isSub(s.right, t);
    }

    private boolean isTreeEquals(TreeNode master, TreeNode slave) {
        if (master == null && slave == null) {
            return true;
        } else if (master != null && slave != null) {
            if (master.val == slave.val) {
                if (!isTreeEquals(master.left, slave.left)) {
                    return false;
                }
                if (!isTreeEquals(master.right, slave.right)) {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        /*
        computeHash(s);
        computeHash(t);
        return isSub(s, t);
        */
        if (isTreeEquals(s, t)) {
            return true;
        } else {
            if (s.left != null) {
                if (isSubtree(s.left, t)) {
                    return true;
                }
            }
            if (s.right != null) {
                if (isSubtree(s.right, t)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}