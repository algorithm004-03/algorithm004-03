# NOTE
class MinStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int x) {
        this.stackData.push(x);
        if (this.stackMin.isEmpty() || x <= this.getMin()) {
            this.stackMin.push(x);
        }
    }

    public void pop() {
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        int val = this.stackData.pop();
        if (val == this.getMin())
            this.stackMin.pop();
    }

    public int top() {
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        return this.stackData.peek();
    }

    public int getMin() {
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty.");
        return this.stackMin.peek();
    }
}






