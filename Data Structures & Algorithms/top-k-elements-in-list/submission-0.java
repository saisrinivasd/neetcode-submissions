class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = entries.get(i).getKey();
        }

        return ans;
    }
}
