//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L125ValidPalindrome {
    public static void main(String[] args) {
         Solution solution = new L125ValidPalindrome().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAlphaNumberic(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') a = (char) (a + 'a' - 'A');
        if (b >= 'A' && b <= 'Z') b = (char) (b + 'a' - 'A');
        return a == b;
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int i = 0, j = s.length() - 1;
        for (; i < j; ++i, --j) {
            while (i < j && !isAlphaNumberic(s.charAt(i))) i++;
            while (i < j && !isAlphaNumberic(s.charAt(j))) j--;
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}