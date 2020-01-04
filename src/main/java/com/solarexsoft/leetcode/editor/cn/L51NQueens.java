//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L51NQueens {
    public static void main(String[] args) {
         Solution solution = new L51NQueens().new Solution();
        System.out.println(solution.solveNQueens(4));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        Set<Integer> col = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        dfs(0, n, col, pie, na, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int row, int n, Set<Integer> col, Set<Integer> pie, Set<Integer> na, List<String> tmpList, List<List<String>> result) {
        if (row == n) {
            if (tmpList.size() == n) {
                result.add(new ArrayList<>(tmpList));
            }
            return;
        }

        boolean exists = false;
        for (int i = 0; i < n; i++) {
            if (col.contains(i) || pie.contains(row + i) || na.contains(row - i)) {
                continue;
            }
            exists = true;
            col.add(i);
            pie.add(row + i);
            na.add(row - i);
            String currentRow = genString(i, n);
            tmpList.add(currentRow);
            dfs(row + 1, n, col, pie, na, tmpList, result);
            col.remove(i);
            pie.remove(row + i);
            na.remove(row - i);
            tmpList.remove(currentRow);
        }
        if (!exists) {
            return;
        }
    }

    private String genString(int col, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}