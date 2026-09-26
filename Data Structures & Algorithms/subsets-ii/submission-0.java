class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        subsetsTwo(0, nums, subset, result);
        return result;
    }

    private void subsetsTwo(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));

        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            subsetsTwo(i + 1, nums, subset, result);
            subset.remove(subset.size() - 1);
        }
    }
}
