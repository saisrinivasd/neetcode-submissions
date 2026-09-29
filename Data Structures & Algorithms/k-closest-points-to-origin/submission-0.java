class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<>(
            (a,b) -> Double.compare(b.getDistance(), a.getDistance()));
        for(int[] point : points) {
            double distance = Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            if(maxHeap.size() < k) {
                maxHeap.offer(new Node(distance, point));
            } else {
                if(maxHeap.peek().getDistance() > distance) {
                    maxHeap.poll();
                    maxHeap.offer(new Node(distance, point));
                }
            }
        }
        int[][] ans = new int[k][2];
        int i =0;
        while(maxHeap.peek() != null) {
            ans[i++] = maxHeap.poll().getPoint();
        }
        return ans;
    }
}

class Node {
    private double distance;
    private int[] point;
    public Node(double distance, int[] point) {
        this.distance = distance;
        this.point = point;
    }

    public double getDistance() {
        return distance;
    }

    public int[] getPoint() {
        return point;
    }
}
