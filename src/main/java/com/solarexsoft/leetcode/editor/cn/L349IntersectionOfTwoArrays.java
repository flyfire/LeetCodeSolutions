//给定两个数组，编写一个函数来计算它们的交集。 
//
// 示例 1: 
//
// 输入: nums1 = [1,2,2,1], nums2 = [2,2]
//输出: [2]
// 
//
// 示例 2: 
//
// 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出: [9,4] 
//
// 说明: 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

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