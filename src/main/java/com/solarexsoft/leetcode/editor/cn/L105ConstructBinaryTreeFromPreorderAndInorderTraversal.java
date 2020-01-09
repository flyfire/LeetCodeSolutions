//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class L105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
         Solution solution = new L105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreePre(preorder, 0, preorder.length - 1, 0, map);
    }

    public TreeNode buildTreePre(int[] preOrder, int preStart, int preEnd, int inStart, Map<Integer, Integer> inPos) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        int rootIndex = inPos.get(preOrder[preStart]);
        int leftLen = rootIndex - inStart;
        root.left = buildTreePre(preOrder, preStart + 1, preStart + leftLen, inStart, inPos);
        root.right = buildTreePre(preOrder, preStart + leftLen + 1, preEnd, rootIndex + 1, inPos);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}