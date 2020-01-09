//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class L106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
         Solution solution = new L106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inPos = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inPos.put(inorder[i], i);
        }
        return buildTreePost(postorder, 0, postorder.length - 1, 0, inPos);
    }

    public TreeNode buildTreePost(int[] post, int postStart, int postEnd, int inStart, Map<Integer, Integer> inPos) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        int rootIndex = inPos.get(post[postEnd]);
        int leftLen = rootIndex - inStart;
        root.left = buildTreePost(post, postStart, postStart + leftLen - 1, inStart, inPos);
        root.right = buildTreePost(post, postStart + leftLen, postEnd - 1, rootIndex + 1, inPos);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}