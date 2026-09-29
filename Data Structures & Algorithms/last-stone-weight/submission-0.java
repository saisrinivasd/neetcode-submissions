class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int stone : stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            
            if(x == y) {
                continue;
            } else {
                maxHeap.offer(x-y);
            }
        }
        if(maxHeap.size() == 1) {
            return maxHeap.peek();
        } else {
            return 0;
        }
    }
}
