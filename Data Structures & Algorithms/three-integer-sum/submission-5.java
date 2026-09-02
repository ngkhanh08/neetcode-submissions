class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;
        int k = 0;

        while (k < n) {
            int target = -nums[k];
            int i = k + 1, j = n - 1;

            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i + 1 < n && nums[i + 1] == nums[i]) {
                        i += 1;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
            while (k + 1 < n && nums[k + 1] == nums[k]) {
                k++;
            }
            k++;
        }
        return ans;
    }
}
