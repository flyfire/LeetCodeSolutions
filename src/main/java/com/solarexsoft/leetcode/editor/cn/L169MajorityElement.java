//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;

public class L169MajorityElement {
    public static void main(String[] args) {
         Solution solution = new L169MajorityElement().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        int maxKey = nums[0];
        int maxKeyCount = countMap.get(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int count = countMap.get(nums[i]);
            if (count > maxKeyCount) {
                maxKeyCount = count;
                maxKey = nums[i];
            }
        }
        return maxKey;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}