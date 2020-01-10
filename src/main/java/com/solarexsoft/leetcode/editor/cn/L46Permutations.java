//给定一个没有重复数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L46Permutations {
    public static void main(String[] args) {
         Solution solution = new L46Permutations().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(numbers, 0, result);
        return result;
    }

    public void permuteHelper(List<Integer> numbers, int start, List<List<Integer>> result) {
        if (start == numbers.size()) {
            result.add(new ArrayList<>(numbers));
        } else {
            for (int i = start; i < numbers.size(); i++) {
                Collections.swap(numbers, i, start);
                permuteHelper(numbers, start + 1, result);
                Collections.swap(numbers, start, i);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}