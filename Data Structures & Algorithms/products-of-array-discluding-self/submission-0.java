class Solution {
    public int[] productExceptSelf(int[] nums) {
     int n = nums.length;
     int[] prod = new int[n];
     prod[0] = 1;
     
     // hande prefixProduct
     for (int i = 1; i < n ; i++){
        prod[i] = prod[i - 1] * nums[i - 1];
     }


      // handle postProduct
     int postPro = 1;
     for(int i = n - 1; i >= 0; i--){
        prod[i] *= postPro;
        postPro *= nums[i];
     }

     return prod;
        
    }
}  
