class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // find all the treasures
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        // BFS
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};



        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= rows ||
                    nc < 0 || nc >= cols) {
                    continue;
                }

                if (grid[nr][nc] == -1){
                    continue;
                }

                 if (grid[nr][nc] != Integer.MAX_VALUE) {
                    continue;
                }
grid[nr][nc] = grid[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
