//设计一个支持以下两种操作的数据结构： 
//
// void addWord(word)
//bool search(word)
// 
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。 
//
// 示例: 
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// 说明: 
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。 
// Related Topics 设计 字典树 回溯算法
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;

public class L211AddAndSearchWordDataStructureDesign {
    public static void main(String[] args) {
        WordDictionary solution = new L211AddAndSearchWordDataStructureDesign().new WordDictionary();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        System.out.println(solution.search("pad"));
        System.out.println(solution.search("bad"));
        System.out.println(solution.search(".ad"));
        System.out.println(solution.search("b.."));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
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

    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(TrieNode node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.containsKey(c)) {
                return match(node.next.get(c), word, index+1);
            } else {
                return false;
            }
        } else {
            for (Character character : node.next.keySet()) {
                if (match(node.next.get(character), word, index+1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}