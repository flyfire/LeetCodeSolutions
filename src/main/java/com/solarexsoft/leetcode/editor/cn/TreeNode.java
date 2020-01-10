package com.solarexsoft.leetcode.editor.cn;

/**
 * Created by houruhou on 2020/1/2.
 * Desc:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
