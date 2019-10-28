package id_693.practise;

import java.util.Stack;

/**
 * @Desc 155.最小栈 https://leetcode-cn.com/problems/min-stack/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/18
 */
public class LeetCode_155_693 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public LeetCode_155_693() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public Integer getMin() {
        try {
            return minStack.peek();
        } catch (Exception e) {
            return null;
        }
    }

    //原来还考虑。后面的数 push更大。会不会出问题。才发现自己理解错误了，栈是先进后出。
    // 汗颜啊。所以后面的513 不录入，然后pop的时候  根本不影响minStack  同时也不影响获得最小的Min。
    // 毕竟最小的 min 是不移除元素的
    public static void main(String[] args) {
        LeetCode_155_693 stack = new LeetCode_155_693();
        //[null,null,null,null,null,null,-1024,null,-1024,null,512]
        System.out.println(stack.getMin());
        stack.push(512);
        stack.push(513);
        stack.pop();
        System.out.println(stack.getMin());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
