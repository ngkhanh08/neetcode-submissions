class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        // Base case or foudn the word
        if (index == word.length()) {
            return true;
        }

        // base case khac whit it is out of bounds
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // basecase khac
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark this cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // explore 4 directions
        boolean found = backtrack(board, word, row - 1, col, index + 1)
            || backtrack(board, word, row + 1, col, index + 1)
            || backtrack(board, word, row, col - 1, index + 1)
            || backtrack(board, word, row, col + 1, index + 1);

        // backtrack store the cell
        board[row][col] = temp;

        return found;
    }
}
