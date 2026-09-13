class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int a = maxHeap.poll();
            int b = maxHeap.poll();

            if (a > b) {
                maxHeap.offer(a - b);
            } 

        }
        return maxHeap.size() > 0 ? maxHeap.peek() : 0;
    }
}
