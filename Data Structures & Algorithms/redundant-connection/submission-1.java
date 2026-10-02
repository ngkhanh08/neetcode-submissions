class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            boolean[] visited = new boolean[n + 1];

            if (dfs(graph, visited, a, b)) {
                return edge;
            }
            graph[a].add(b);
            graph[b].add(a);
        }
        return new int[0];
    }

    private boolean dfs(List<Integer>[] graph, boolean[] visited, int node, int target) {
        if (node == target) {
            return true;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                if (dfs(graph, visited, next, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
