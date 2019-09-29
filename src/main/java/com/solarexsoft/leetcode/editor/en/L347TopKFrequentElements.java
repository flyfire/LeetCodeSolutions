//Given a non-empty array of integers, return the k most frequent elements. 
//
// Example 1: 
//
// 
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1] 
// 
//
// Note: 
//
// 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements. 
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size. 
// 
// Related Topics Hash Table Heap
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.en;

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