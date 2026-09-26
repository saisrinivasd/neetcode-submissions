class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.merge(n, 1, Integer::sum);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(freqMap.get(a), freqMap.get(b)));

        for(int key : freqMap.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }
        return ans;
    }
}
