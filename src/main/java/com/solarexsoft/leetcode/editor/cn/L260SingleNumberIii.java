//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L260SingleNumberIii {
    public static void main(String[] args) {
         Solution solution = new L260SingleNumberIii().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = xor & -xor;
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}