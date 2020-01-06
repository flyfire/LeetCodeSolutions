//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;

public class L212WordSearchIi {
    public static void main(String[] args) {
         Solution solution = new L212WordSearchIi().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
    }

    private class TrieNode{
        public boolean isWord;
        public HashMap<Character, TrieNode> next;

        public TrieNode(boolean isWord) {
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public TrieNode() {
            this(false);
        }
    }

    private class Trie {
        TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.next.containsKey(c)){
                    cur.next.put(c, new TrieNode());
                }
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.next.containsKey(c)) {
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!cur.next.containsKey(c)) {
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}