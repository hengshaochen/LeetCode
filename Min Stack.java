class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    public MinStack() {
        stack = new Stack<Integer>();
        min_stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        // 若min_stack的頭比新來的值大 or 為空 --> push x進入
        if (min_stack.isEmpty() || min_stack.peek() > x) {
            min_stack.push(x);
        } else {
            min_stack.push(min_stack.peek());
        }
        stack.push(x);
    }
    
    public void pop() {
        min_stack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
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

