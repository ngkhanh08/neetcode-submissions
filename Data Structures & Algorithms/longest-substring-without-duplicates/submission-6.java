class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++){ // O(N)
            while(charSet.contains(s.charAt(r))){ // O(1)
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
        
    }
    // TC: O(N) SC: O(M) 
}
