class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;  // minimum possible speed
        int right = getMax(piles);  // maximum pile size
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // current eating speed

            if (canFinish(piles, h, mid)) {
                ans = mid;        // possible answer, try smaller speed
                right = mid - 1;
            } else {
                left = mid + 1;   // speed too small, try higher
            }
        }

        return ans;
    }

    // Helper to check if Koko can eat all piles with speed k in h hours
    private boolean canFinish(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + k - 1) / k;
        }
        return time <= h;
    }

    // Helper to get the maximum value in the array
    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }
}
