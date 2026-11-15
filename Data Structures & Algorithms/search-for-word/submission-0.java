class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (backtrack(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean backtrack(char[][] board, String word,
                      int row, int col, int index,
                      boolean[][] visited) {

        // Boundary, visited and character checks
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            visited[row][col] ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        // Entire word found
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell
        visited[row][col] = true;

        // Explore four directions
        boolean found =
            backtrack(board, word, row - 1, col, index + 1, visited) ||
            backtrack(board, word, row + 1, col, index + 1, visited) ||
            backtrack(board, word, row, col - 1, index + 1, visited) ||
            backtrack(board, word, row, col + 1, index + 1, visited);

        // Backtrack
        visited[row][col] = false;

        return found;
    }
}
