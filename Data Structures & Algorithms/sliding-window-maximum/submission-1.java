class Solution {
    Deque<Integer> candidateQueue = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < k; i++) {
            enqueue(nums[i]);
        }

        int[] res = new int[n - k + 1];
        for (int i = k; i < n; i++) {
            res[i - k] = getMax();
            dequeue(nums[i - k]);
            enqueue(nums[i]);
        }
        res[n - k] = getMax();

        return res;
    }

    public void enqueue(int x){
        while(!candidateQueue.isEmpty() && candidateQueue.peekLast() < x){
            candidateQueue.removeLast();
        }
        candidateQueue.addLast(x);
    }

    public void dequeue (int removedElement){
        if(!candidateQueue.isEmpty() && candidateQueue.peekFirst() == removedElement){
            candidateQueue.removeFirst();
        }
    }

    public int getMax(){
        return candidateQueue.peekFirst();
    }
}
