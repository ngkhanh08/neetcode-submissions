class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        // put all word into tries;
        for (String word : words) {
            insert(word);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, res);
            }
        }

        return res;
    }

    private void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        // base case
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        int index = ch - 'a';

        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        if (next.word != null) {
            res.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';

        dfs(board, r + 1, c, next, res);
        dfs(board, r - 1, c, next, res);
        dfs(board, r, c + 1, next, res);
        dfs(board, r, c - 1, next, res);

        board[r][c] = ch;
    }
}
