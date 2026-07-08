class Solution {
    public int reverseBits(int n) {
       int left = 0, right = 31;

       while ( left < right){
         int i = getBit(n, right);
         int j = getBit(n, left);
          
         if (i != j){
            n = flip(n, right);
            n = flip(n, left);
         }
         right--;
         left++;
       } 
    return n;
    }
    public int getBit(int n, int k){
        return (n >> k) & 1;
    }

    public int flip(int n, int k){
        return n ^ (1 << k);
    }
}
