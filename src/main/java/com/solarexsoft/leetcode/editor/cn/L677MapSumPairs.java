//实现一个 MapSum 类里的两个方法，insert 和 sum。 
//
// 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。 
//
// 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。 
//
// 示例 1: 
//
// 输入: insert("apple", 3), 输出: Null
//输入: sum("ap"), 输出: 3
//输入: insert("app", 2), 输出: Null
//输入: sum("ap"), 输出: 5
// 
// Related Topics 字典树
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;

public class L677MapSumPairs {
    public static void main(String[] args) {
        MapSum solution = new L677MapSumPairs().new MapSum();
        solution.insert("apple", 3);
        System.out.println(solution.sum("ap"));
        solution.insert("app", 2);
        System.out.println(solution.sum("ap"));
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    private class TrieNode{
        public int value;
        public HashMap<Character, TrieNode> next;

        public TrieNode(int value){
            this.value = value;
            next = new HashMap<>();
        }

        public TrieNode() {
            this(0);
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)){
                cur.next.put(c, new TrieNode());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(TrieNode cur) {
        int res = cur.value;
        for (Character character : cur.next.keySet()) {
            res += sum(cur.next.get(character));
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}