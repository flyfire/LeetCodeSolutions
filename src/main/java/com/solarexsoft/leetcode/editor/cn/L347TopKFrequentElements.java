//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 说明： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 
// Related Topics 堆 哈希表
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.*;

public class L347TopKFrequentElements {
    public static void main(String[] args) {
         Solution solution = new L347TopKFrequentElements().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 比较出现的次数
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer integer : map.keySet()) {
            if (queue.size() < k) {
                queue.add(integer);
            } else if (map.get(integer) > map.get(queue.peek())) { // PriorityQueue是小根堆，如果出现频率比小根堆的堆顶元素的出现频率大，将堆顶元素出队，重新添加新的元素
                queue.remove();
                queue.add(integer);
            }
        }
        LinkedList<Integer> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}