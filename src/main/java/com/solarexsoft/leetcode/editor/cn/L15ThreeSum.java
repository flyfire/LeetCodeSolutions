//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.*;

public class L15ThreeSum {
    public static void main(String[] args) {
         Solution solution = new L15ThreeSum().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        int len = nums.length;
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < len - 2; i++) {
            if (i >= 1 && nums[i] == nums[i-1]) {
                continue;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < len; j++) {
                if (!map.containsKey(nums[j])) {
                    map.put(-nums[i] - nums[j], 1);
                } else {
                    set.add(Arrays.asList(nums[i], nums[j], -nums[i]-nums[j]));
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}