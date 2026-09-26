class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    queue.add(new Pair(i,j));
                    visited[i][j] = 1;
                }
            }
        }

        int distance = 0;
        while(!queue.isEmpty()) {
            int s = queue.size();
            for(int k = 0; k < s; k++) {
                Pair pair = queue.poll();
                int i = pair.getRow();
                int j = pair.getColumn();
                grid[i][j] = distance;
                addToQueue(i-1, j, queue, grid, visited);
                addToQueue(i+1, j, queue, grid, visited);
                addToQueue(i, j-1, queue, grid, visited);
                addToQueue(i, j+1, queue, grid, visited);
            }
            distance++;
        }
    }

    private void addToQueue(int i, int j, Queue<Pair> queue, int[][] grid, int[][] visited) {
        if(i < 0 || i == grid.length ||
        j < 0 || j == grid[0].length ||
        grid[i][j] == -1 ||
        visited[i][j] == 1) {
            return;
        }
        queue.add(new Pair(i,j));
        visited[i][j] = 1;
    }
}

private class Pair {
    int row;
    int column;
    public Pair(int r, int c) {
        this.row = r;
        this.column = c;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
