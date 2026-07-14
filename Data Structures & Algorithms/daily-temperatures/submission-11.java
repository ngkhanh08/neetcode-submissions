class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // In Java, an int[] is automatically initialized with 0s, 
        // so we don't need to manually set the 0s for days that never warm up.
        int[] res = new int[n]; 
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While the current day is warmer than the day at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // We found a warmer day for 'prevDay'!
                int prevDay = stack.pop();
                
                // The wait time is the difference in indices
                res[prevDay] = i - prevDay; 
            }
            // Push the current day onto the stack to wait for its warmer day
            stack.push(i);
        }
        
        return res;
    }
}