//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

/*
 * Author: Solarex
 * Solutions: https://github.com/flyfire/LeetCodeSolutions
 * SolutionComments: https://solarex.github.io/leetcode-solution-comments/
 */
package com.solarexsoft.leetcode.editor.cn;

import java.util.Stack;

public class L155MinStack {
    public static void main(String[] args) {
         MinStack minStack = new L155MinStack().new MinStack();
         minStack.push(-2);
         minStack.push(0);
         minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> valStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        valStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            Integer topMin = minStack.peek();
            int pushMin = Math.min(topMin, x);
            minStack.push(pushMin);
        }
    }
    
    public void pop() {
        valStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}