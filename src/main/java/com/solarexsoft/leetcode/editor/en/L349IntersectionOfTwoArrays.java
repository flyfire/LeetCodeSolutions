//Given two arrays, write a function to compute their intersection. 
//
// Example 1: 
//
// 
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
// 
//
// 
// Example 2: 
//
// 
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4] 
// 
//
// Note: 
//
// 
// Each element in the result must be unique. 
// The result can be in any order. 
// 
//
// 
// Related Topics Hash Table Two Pointers Binary Search Sort
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.en;

import java.util.HashSet;
import java.util.Iterator;

public class L349IntersectionOfTwoArrays {
    public static void main(String[] args) {
         Solution solution = new L349IntersectionOfTwoArrays().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> inter = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                inter.add(i);
            }
        }
        Iterator<Integer> iterator = inter.iterator();
        int[] result = new int[inter.size()];
        int index = 0;
        while (iterator.hasNext()) {
            result[index++] = iterator.next();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}