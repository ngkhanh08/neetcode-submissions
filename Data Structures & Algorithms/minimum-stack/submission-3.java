class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        // Idea : monoStack : don dieu, thu tu tang dan hoac giam dan
        // 1. Monostack giup minh tim min trong O1 nhuw the nao .
        // Chinh la monstak[-1]
        // update monotakcj kjhi push nhu the nao. so sanh val
        // dung monostack de luu index chu khong luuw value
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
