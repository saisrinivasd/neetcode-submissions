class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.merge(n, 1, Integer::sum);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(freqMap.get(b), freqMap.get(a)));

        for(int key : freqMap.keySet()) {
            maxHeap.add(key);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }
        return ans;
    }
}
