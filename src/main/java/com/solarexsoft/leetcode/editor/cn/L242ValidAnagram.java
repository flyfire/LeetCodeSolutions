//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L242ValidAnagram {
    public static void main(String[] args) {
         Solution solution = new L242ValidAnagram().new Solution();
         solution.isAnagram("aaabbb", "ababab");
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
        /*
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for (int i = 0; i < sFreq.length; i++) {
//            sFreq[i] = 0;
//            tFreq[i] = 0;
            System.out.println(sFreq[i] + " --> " + tFreq[i]);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sFreq[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tFreq[c - 'a']++;
        }
        for (int i = 0; i < sFreq.length; i++) {
            if (sFreq[i] != tFreq[i]) {
                return false;
            }
        }
        return true;
        */
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}