class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Optimal: Map to store eles as key and idx as value
        int[] ans = new int[2];

        Map<Integer, Integer> elesMap = new HashMap<>();
        for(int i = 0; i <nums.length; i++) {
            if(elesMap.containsKey(target - nums[i])) {
                ans[0] = elesMap.get(target - nums[i]);
                ans[1] = i;
                break;
            } else {
                elesMap.put(nums[i], i);
            }
        }
        return ans;
    }
}
