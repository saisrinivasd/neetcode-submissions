class MedianFinder {
    PriorityQueue<Integer> mx;
    PriorityQueue<Integer> mn;
    public MedianFinder() {
        this.mx = new PriorityQueue<>(Comparator.reverseOrder());
        this.mn = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(mx.isEmpty() || num > mx.peek()) {
            mn.offer(num);
        } else {
            mx.offer(num);
        }

        if(mx.size() > mn.size() + 1) {
            mn.offer(mx.poll());
        } else if(mx.size() < mn.size()) {
            mx.offer(mn.poll());
        }
    }
    
    public double findMedian() {
        if(mx.size() == mn.size()) {
            return (mx.peek() + mn.peek()) / 2.0;
        } 
        return mx.peek();
    }
}
