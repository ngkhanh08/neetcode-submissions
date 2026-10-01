class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph[prerequisite].add(course);
        }

        int[] state = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(graph, state, i, ans)) {
                    return new int[0];
                }
            }
        }

        Collections.reverse(ans);

        int[] result = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    private boolean dfs(List<Integer>[] graph, int[] state, int course, List<Integer> ans) {
        if (state[course] == 1) {
            return false;
        }

        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;

        for (int next : graph[course]) {
            if (!dfs(graph, state, next, ans)) {
                return false;
            }
        }

        state[course] = 2;
        ans.add(course);

        return true;
    }
}
