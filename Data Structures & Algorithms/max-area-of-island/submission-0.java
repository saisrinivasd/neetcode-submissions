class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    int currentArea = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 0;
        }

        // Mark as visited
        grid[i][j] = 0;

        int area = 1;

        area += dfs(grid, i - 1, j); // up
        area += dfs(grid, i + 1, j); // down
        area += dfs(grid, i, j - 1); // left
        area += dfs(grid, i, j + 1); // right

        return area;
    }
}
