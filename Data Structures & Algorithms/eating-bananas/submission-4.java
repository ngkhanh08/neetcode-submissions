class Solution {
    public int minEatingSpeed(int[] piles, int h) {

    int left = 1, right = getMax(piles), ans = right;

    while (left <= right){
      int mid = left + (right - left)/2;

      if (canFinish(piles, h, mid)){
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
      
    return ans;
    }

    private boolean canFinish (int[] piles,int h,int k){
    int time = 0;

    for (int pile : piles){
        time += (pile + k - 1)/k;
    }

    return time <= h;
    }

    private int getMax(int[] piles){
        int max = 0;

    for (int pile : piles){
        if(pile > max){
            max = pile;
        }
    }
    return max;
    }
}
