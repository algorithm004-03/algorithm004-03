//155. 最小栈


//解法1：通过创建一个辅助栈存储主栈中的最小值
//push，pop，top，getmin的时间复杂度都为O(1)
//空间复杂度O(n)，考虑到极端情况下dataStack入栈的所有元素相同，那么也要创建一个与dataStack大小相同的helpStack
public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> helpStack;

    public MinStack() {
        dataStack = new Stack<>();
        helpStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (helpStack.isEmpty() || x <= helpStack.peek()) {
           helpStack.push(x);
        }
    }

    public void pop() {
        int x = dataStack.pop();
        if (x == helpStack.peek()) {
           helpStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return helpStack.peek();
    }

}