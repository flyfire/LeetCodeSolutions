//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class L22GenerateParentheses {
    public static void main(String[] args) {
         Solution solution = new L22GenerateParentheses().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        genParenthesis(0, 0, n, "", result);
        return result;
    }

    private void genParenthesis(int left, int right, int n, String str, List<String> result) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        if (left < n) {
            genParenthesis(left + 1, right, n, str + "(", result);
        }
        if (left > right && right < n) {
            genParenthesis(left, right + 1, n, str + ")", result);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}