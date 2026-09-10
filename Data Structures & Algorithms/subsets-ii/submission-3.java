class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res, subset);
        return res;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> subset) {
            res.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            dfs(nums, j + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
