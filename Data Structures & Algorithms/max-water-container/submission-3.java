class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int maxWater = 0;
        //Brute
        // for(int i = 0; i < n; i++) {
        //     for(int j = i+1; j < n; j++) {
        //         int minHeight = Math.min(heights[i], heights[j]);
        //         maxWater = Math.max(maxWater, minHeight * (j-i));
        //     }
        // }

        //Optimal - Two pointers
        int left = 0;
        int right = n-1;
        while(left < right) {
            int minHeight = Math.min(heights[left], heights[right]);
            maxWater = Math.max(maxWater, minHeight * (right-left));
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
