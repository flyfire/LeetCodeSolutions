//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.*;

public class L47PermutationsIi {
    public static void main(String[] args) {
         Solution solution = new L47PermutationsIi().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        Set<List<Integer>> result = new HashSet<>();
        permuteUniqueHelper(numbers, 0, result);
        return new ArrayList<>(result);
    }

    public void permuteUniqueHelper(List<Integer> numbers, int start, Set<List<Integer>> result) {
        if (start == numbers.size()) {
            result.add(new ArrayList<>(numbers));
        } else {
            for (int i = start; i < numbers.size(); i++) {
                Collections.swap(numbers, i, start);
                permuteUniqueHelper(numbers, start + 1, result);
                Collections.swap(numbers, start, i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}