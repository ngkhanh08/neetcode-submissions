class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Check if current temp is greater than the temp at top index of stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // how many days to wait
            }
            stack.push(i); // push current index
        }

        return result;
    }


    }
