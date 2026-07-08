class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        
        // Set for handling duplicate nums
        for (int num: nums){
            numSet.add(num);
        }
      
        int longest = 0;

        for(int num: numSet) {
            // make sure num is the first of sequence, no num - 1 exists
            if (!numSet.contains(num - 1)){
                int length = 1;
                // check num +1 , num + 1. ... sequietial numbers.
                while(numSet.contains(num + length)){
                    length++;
                }
                // longest comaprasion
                longest = Math.max(longest,length);
            }
        }
          return longest;






    }
}
