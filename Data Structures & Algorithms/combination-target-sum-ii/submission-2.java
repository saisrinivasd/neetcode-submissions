class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, ans, subset);
        return ans;
    }

    private void solve(
        int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> subset) {
        if (target == 0) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if(i != index && arr[i] == arr[i-1]) {
                continue;
            }
            if(arr[i] > target) {
                break;
            }
            subset.add(arr[i]);
            solve(arr, target - arr[i], i + 1, ans, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
