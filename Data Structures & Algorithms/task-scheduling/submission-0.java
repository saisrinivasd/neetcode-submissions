class Solution {
    static class Task {
        char task;
        int remaining;
        int availableAt;
        public Task(char task, int remaining, int availableAt) {
            this.task = task;
            this.remaining = remaining;
            this.availableAt = availableAt;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b.remaining, a.remaining));
        Queue<Task> cooldown = new ArrayDeque<>();
        int[] freq = new int[26];
        
        //count frequencies
        for(char task : tasks) {
            freq[task - 'A']++;
        }

        //put into queue
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                maxHeap.offer(new Task((char)('A' + i), freq[i], 0));
            }
        }

        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            //release available tasks from queue
            while(!cooldown.isEmpty() && cooldown.peek().availableAt <= time) {
                maxHeap.offer(cooldown.poll());
            }

            if(!maxHeap.isEmpty()) {
                Task current = maxHeap.poll();
                current.remaining--;
                if(current.remaining > 0) {
                    current.availableAt = time + n + 1;
                    cooldown.offer(current);
                }
                time++;
            } else {
                //to avoid incrementing each idle cycle, jump to next availableAt time directly
                time = cooldown.peek().availableAt;
            }
        }

        return time;
    }
}
