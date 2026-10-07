class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n+1];

        //edge case
        dp[0] = 1;

        //mot digit dau tien
        if(s.charAt(0) != '0'){
            dp[1] = 1;
        }

        for(int i = 2; i <= n; i++){

            // 1 digit
            if(s.charAt(i - 1) != '0'){
                dp[i] += dp[i-1];
            }

            //2 digit
            int twoDigit = Integer.parseInt(s.substring(i-2,i));

            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i-2];
            }
             
        }return dp[n];
     }
}
