class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++){
        ans[i] = getBit(i);
        }
        return ans;

    }

    public int getBit(int i){
        if (i == 0) return 0;
        int result = 0;
        while (i != 0){
            result++;
            i = i & (i - 1);
        }
        return result;
    }
}
