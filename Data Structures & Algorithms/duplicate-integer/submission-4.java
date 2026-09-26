class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) {
            return false;
        }

        Set<Integer> numSet = new HashSet<>();

        for(int i = 0; i< n; i++) {
            if(numSet.contains(nums[i])) {
                return true;
            }
            numSet.add(nums[i]);
        }
        return false;
    }
}