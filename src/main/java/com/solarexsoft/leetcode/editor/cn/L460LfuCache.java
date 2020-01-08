//设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。 
//
// get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。 
//put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平
//局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。 
//
// 进阶： 
//你是否可以在 O(1) 时间复杂度内执行两项操作？ 
//
// 示例： 
//
// 
//LFUCache cache = new LFUCache( 2 /* capacity (缓存容量) */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回 1
//cache.put(3, 3);    // 去除 key 2
//cache.get(2);       // 返回 -1 (未找到key 2)
//cache.get(3);       // 返回 3
//cache.put(4, 4);    // 去除 key 1
//cache.get(1);       // 返回 -1 (未找到 key 1)
//cache.get(3);       // 返回 3
//cache.get(4);       // 返回 4 
// Related Topics 设计

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class L460LfuCache {
    public static void main(String[] args) {
        LFUCache cache = new L460LfuCache().new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("vals");
        printMap(cache.vals);
        System.out.println("counts");
        printMap(cache.counts);
        System.out.println("samecountlists");
        printSameCountLists(cache.sameCountLists);
        System.out.println("min = " + cache.min + "\n-------------");
        System.out.println("get(1) = " + cache.get(1));;
        System.out.println("vals");
        printMap(cache.vals);
        System.out.println("counts");
        printMap(cache.counts);
        System.out.println("samecountlists");
        printSameCountLists(cache.sameCountLists);
        System.out.println("min = " + cache.min + "\n-------------");
        cache.put(3, 3);
        System.out.println("vals");
        printMap(cache.vals);
        System.out.println("counts");
        printMap(cache.counts);
        System.out.println("samecountlists");
        printSameCountLists(cache.sameCountLists);
        System.out.println("min = " + cache.min + "\n-------------");
        System.out.println("get(2) = " + cache.get(2));
        System.out.println("get(3) = " + cache.get(3));
        cache.put(4, 4);
        System.out.println("vals");
        printMap(cache.vals);
        System.out.println("counts");
        printMap(cache.counts);
        System.out.println("samecountlists");
        printSameCountLists(cache.sameCountLists);
        System.out.println("min = " + cache.min + "\n-------------");
        System.out.println("get(1) = " + cache.get(1));
        System.out.println("get(3) = " + cache.get(3));
        System.out.println("get(4) = " + cache.get(4));
        System.out.println("vals");
        printMap(cache.vals);
        System.out.println("counts");
        printMap(cache.counts);
        System.out.println("samecountlists");
        printSameCountLists(cache.sameCountLists);
        System.out.println("min = " + cache.min + "\n-------------");
    }

    static void printMap(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        System.out.println();
    }

    static void printSameCountLists(HashMap<Integer, LinkedHashSet<Integer>> map) {
        for (Map.Entry<Integer, LinkedHashSet<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " --> {");
            for (Integer keys : entry.getValue()) {
                System.out.print(keys + ",");
            }
            System.out.println("}");
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> sameCountLists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        sameCountLists = new HashMap<>();
        sameCountLists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        sameCountLists.get(count).remove(key);

        if (count == min && sameCountLists.get(count).size() == 0) {
            min++;
        }
        if (!sameCountLists.containsKey(count + 1)) {
            sameCountLists.put(count + 1, new LinkedHashSet<>());
        }
        sameCountLists.get(count + 1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() >= cap) {
            int evit = sameCountLists.get(min).iterator().next();
            sameCountLists.get(min).remove(evit);
            vals.remove(evit);
            counts.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        sameCountLists.get(1).add(key);
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}