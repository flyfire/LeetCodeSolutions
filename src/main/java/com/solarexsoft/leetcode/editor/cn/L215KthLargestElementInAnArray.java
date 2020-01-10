//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class L215KthLargestElementInAnArray {
    public static void main(String[] args) {
         Solution solution = new L215KthLargestElementInAnArray().new Solution();
         int[] nums = {3,2,1,5,6,4};
         int kth = solution.findKthLargest(nums, 2);
        System.out.println(kth);
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                int heapTop = queue.peek();
                if (num > heapTop) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}