class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];

        if (!dfs(graph, visited, 0, -1)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<Integer>[] graph, boolean[] visited, int node, int parent) {
        if (visited[node]) {
            return false;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (next == parent) {
                continue;
            }
            if (!dfs(graph, visited, next, node)) {
                return false;
            }
        }
        return true;
    }
}
