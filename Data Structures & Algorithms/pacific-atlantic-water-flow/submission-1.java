class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // dfs
        for (int c = 0; c < cols; c++) {
            dfs(heights, pacific, 0, c, rows, cols);
            dfs(heights, atlantic, rows - 1, c, rows, cols);
        }

        for (int r = 0; r < rows; r++) {
            dfs(heights, pacific, r, 0, rows, cols);
            dfs(heights, atlantic, r, cols - 1, rows, cols);
        }

        // rs
        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int rows, int cols) {
        visited[r][c] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            if (heights[nr][nc] < heights[r][c]) {
                continue;
            }

            dfs(heights, visited, nr, nc, rows, cols);
        }
    }
}
