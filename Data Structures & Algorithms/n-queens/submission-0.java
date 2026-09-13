class Solution { 

    public List<List<String>> solveNQueens(int n) { 
        
        List<List<String>> res = new ArrayList<>(); 

        // create chess board
        char[][] board = new char[n][n]; 

        for (int row = 0; row < n; row++) { 
            Arrays.fill(board[row], '.'); 
        } 

        backtrack(0, board, res); 

        return res; 
    } 


    private void backtrack(
        int row, 
        char[][] board, 
        List<List<String>> res
    ) { 

        if (row == board.length) { 

            List<String> solution = new ArrayList<>(); 

            for (char[] r : board) { 
                solution.add(new String(r)); 
            } 

            res.add(solution); 
            return; 
        } 


        for (int col = 0; col < board.length; col++) { 

            if (!isSafe(board, row, col)) { 
                continue; 
            } 

            // choose
            board[row][col] = 'Q'; 

            // explore
            backtrack(row + 1, board, res); 

            // undo
            board[row][col] = '.'; 
        } 
    } 


    private boolean isSafe(char[][] board, int row, int col) { 

        int n = board.length; 


        // check column
        for (int r = row - 1; r >= 0; r--) { 

            if (board[r][col] == 'Q') { 
                return false; 
            } 
        } 


        // check upper-left diagonal
        for (
            int r = row - 1, c = col - 1; 
            r >= 0 && c >= 0; 
            r--, c--
        ) { 

            if (board[r][c] == 'Q') { 
                return false; 
            } 
        } 


        // check upper-right diagonal
        for (
            int r = row - 1, c = col + 1; 
            r >= 0 && c < n; 
            r--, c++
        ) { 

            if (board[r][c] == 'Q') { 
                return false; 
            } 
        } 


        return true; 
    } 
}