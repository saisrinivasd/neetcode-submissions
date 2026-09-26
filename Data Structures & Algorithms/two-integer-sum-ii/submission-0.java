class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            } else {
                res[0] = left+1;
                res[1] = right+1;
                break;
            }
        }
        return res;
    }
}
