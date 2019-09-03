###LeetcodeEditor 配置

+ 文件名

```
L${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})
```

+ 文件模板

```java
${question.content}
/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;
public class L${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug}) {
    public static void main(String[] args) {
         Solution solution = new L${question.frontendQuestionId}$!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    ${question.code}
}
```