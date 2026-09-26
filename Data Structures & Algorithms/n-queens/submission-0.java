class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] rows = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2*n - 1];
        boolean[] upperDiagonal = new boolean[2*n - 1];
        int[] queenCol = new int[n];
        solve(0, queenCol, rows, lowerDiagonal, upperDiagonal, ans, n);
        return ans;
    }

    private void solve(int col, int[] queenCol, boolean[] rows, boolean[] lowerDiagonal, boolean[] upperDiagonal, List<List<String>> ans, int n) {
        if(col == n) {
            List<String> currentBoard = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                char[] queenRow = new char[n];
                Arrays.fill(queenRow, '.');
                queenRow[queenCol[i]] = 'Q';
                currentBoard.add(new String(queenRow));
            }
            ans.add(currentBoard);
            return;
        }

        for(int row = 0; row < n; row++) {
            if(!rows[row] && !lowerDiagonal[row+col] && !upperDiagonal[(col-row)+n-1]) {
                queenCol[row] = col;
                rows[row] = true;
                lowerDiagonal[row+col] = true;
                upperDiagonal[(col - row) + (n-1)] = true;
                solve(col+1, queenCol, rows, lowerDiagonal, upperDiagonal, ans, n);
                rows[row] = false;
                lowerDiagonal[row+col] = false;
                upperDiagonal[(col - row) + (n-1)] = false;
            }
        }
    }
}
