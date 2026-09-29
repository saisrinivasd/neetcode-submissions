class KthLargest {

    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k) {
            minHeap.offer(val);
        } else if(minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        
        }

        return minHeap.peek();
    }
}
