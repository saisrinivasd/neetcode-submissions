class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        findPermutations(nums, permutations, currentPermutation, visited);
        return permutations;
    }

    private void findPermutations(int[] nums, List<List<Integer>> permutations, List<Integer> currentPermutation, boolean[] visited) {
        if(currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                currentPermutation.add(nums[i]);
                findPermutations(nums, permutations, currentPermutation, visited);
                currentPermutation.remove(currentPermutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
