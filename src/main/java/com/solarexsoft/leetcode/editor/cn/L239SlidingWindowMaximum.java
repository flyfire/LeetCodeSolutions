//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.TreeMap;

public class L239SlidingWindowMaximum {
    public static void main(String[] args) {
         Solution solution = new L239SlidingWindowMaximum().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        int len = nums.length;
        int[] result = new int[len - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            map.put(nums[i], i);
        }
        int p = 0;
        result[p++] = map.lastKey();
        for (int i = k; i < len; i++) {
            if (map.get(nums[i - k]) == i-k) {
                map.remove(nums[i-k]);
            }
            map.put(nums[i], i);
            result[p++] = map.lastKey();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}