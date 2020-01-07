//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.List;

public class L120Triangle {
    public static void main(String[] args) {
         Solution solution = new L120Triangle().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        List<Integer> lastRow = triangle.get(row - 1);
        int col = lastRow.size();
        int[][] result = new int[row][col];
        for (int i = 0; i < col; i++) {
            result[row - 1][i] = lastRow.get(i);
        }
        for (int i = row-2; i >= 0; i--) {
            List<Integer> rowInts = triangle.get(i);
            int size = rowInts.size();
            for (int rowIndex = 0; rowIndex < size; rowIndex++) {
                result[i][rowIndex] = Math.min(result[i+1][rowIndex], result[i+1][rowIndex+1]) + rowInts.get(rowIndex);
            }
        }
        /*
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
        */
        return result[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}