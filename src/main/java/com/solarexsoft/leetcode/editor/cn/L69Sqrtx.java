//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L69Sqrtx {
    public static void main(String[] args) {
         Solution solution = new L69Sqrtx().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (mid <= x/mid && (mid+1) > x /(mid+1)) {
                return mid;
            } else if (mid > x/mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}