//国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。 
//
// 为了方便，所有26个英文字母对应摩尔斯密码表如下： 
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."] 
//
// 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。 
//
// 返回我们可以获得所有词不同单词翻译的数量。 
//
// 例如:
//输入: words = ["gin", "zen", "gig", "msg"]
//输出: 2
//解释: 
//各单词翻译如下:
//"gin" -> "--...-."
//"zen" -> "--...-."
//"gig" -> "--...--."
//"msg" -> "--...--."
//
//共有 2 种不同翻译, "--...-." 和 "--...--.".
// 
//
// 
//
// 注意: 
//
// 
// 单词列表words 的长度不会超过 100。 
// 每个单词 words[i]的长度范围为 [1, 12]。 
// 每个单词 words[i]只包含小写字母。 
// 
// Related Topics 字符串
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.HashSet;

public class L804UniqueMorseCodeWords {
    public static void main(String[] args) {
         Solution solution = new L804UniqueMorseCodeWords().new Solution();
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseWords = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> uniqueStr = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseWords[word.charAt(i) - 'a']);
            }
            uniqueStr.add(sb.toString());
        }
        return uniqueStr.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}