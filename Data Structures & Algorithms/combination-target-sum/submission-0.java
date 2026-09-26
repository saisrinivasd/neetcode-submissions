class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        int sum = 0;
        dfs(nums, 0, sum, subset, res, target);
        return res;
    }

    private void dfs(int[] nums, int i, int sum, List<Integer> subset, List<List<Integer>> res, int target) {
        if(i >= nums.length || sum > target) {
            return;
        }

        if(sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(nums, i, sum+nums[i], subset, res, target);
        subset.remove(subset.size() - 1);
        dfs(nums, i+1, sum, subset, res, target);
    }
}
