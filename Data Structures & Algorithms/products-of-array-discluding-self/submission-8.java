class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prod = new int[n];
        prod[0] = 1;

        // handle prefixsum
        for (int i = 1; i < n; i++) {
            prod[i] = nums[i-1] * prod[i - 1];
            System.out.println(prod[i]);
        }

        // handel postSum
        int postSum = 1;
        for (int i = n - 1; i >= 0; i--) {
           prod[i] *= postSum;
        //   System.out.println(prod[i]);
           postSum *= nums[i];
        //    System.out.println(postSum);
        }

        return prod;
    }
}
