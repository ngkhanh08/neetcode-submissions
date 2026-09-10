class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, 0, target, res, cur);

        return res;
    }

    private void backtrack(
        int[] nums,
        int start,
        int target,
        List<List<Integer>> res,
        List<Integer> cur
    ) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate numbers at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Since array is sorted, no later number can work
            if (nums[i] > target) {
                break;
            }

            cur.add(nums[i]);

            // i + 1 because each number can only be used once
            backtrack(nums, i + 1, target - nums[i], res, cur);

            cur.remove(cur.size() - 1);
        }
    }
}