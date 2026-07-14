class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Using a switch statement or .equals() for string comparison
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop(); // right operand
                int b = stack.pop(); // left operand
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop(); // right operand
                int b = stack.pop(); // left operand
                stack.push(b / a);
            } else {
                // It's a number, parse and push
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
}