//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. 
//
// Example: 
// 
//Given nums = [-2, 0, 3, -5, 2, -1]
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3
// 
// 
//
// Note: 
// 
// You may assume that the array does not change. 
// There are many calls to sumRange function. 
// 
// Related Topics Dynamic Programming
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.en;
public class L303RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray array = new L303RangeSumQueryImmutable().new NumArray(nums);
        System.out.println(array.sumRange(0, 5));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    private int[] sums; // sums[i] 存储nums 0...i-1 的和
    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}