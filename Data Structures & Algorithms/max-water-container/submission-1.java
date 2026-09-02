class Solution {
    public int maxArea(int[] heights) {
    int ans = 0;
     int i = 0, j = heights.length - 1;

     while (i < j){
        int amount = ( j - i) * Math.min(heights[i], heights[j]);
         ans = Math.max(ans, amount);

         if (heights[i] < heights[j]){
            i++;
         } else {
            j--;
         }
     }

     return ans;


    }
}
