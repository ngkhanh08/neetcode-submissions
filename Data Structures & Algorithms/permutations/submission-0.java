class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, res, cur, used);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            cur.add(nums[i]);
            used[i] = true;

            backtrack(nums, res, cur, used);

            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
