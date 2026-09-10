class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Ides Sinh current SOlotion vois currren solution la so lan xuay hien cuar candidate i
        // torng loi giai

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(nums, 0,res, cur, target);
        return res;
    }

    private void backtrack(
        int[] nums, int i, List<List<Integer>> res, List<Integer> cur, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, i, res, cur, target - nums[i]);
        cur.remove(cur.size() - 1);
        backtrack(nums, i + 1, res, cur, target);
    }
}
