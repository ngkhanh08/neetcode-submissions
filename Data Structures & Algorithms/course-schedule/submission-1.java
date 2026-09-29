class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];

        for(int i =0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }


        for (int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            graph[prerequisite].add(course);
        } 

        int[] state = new int[numCourses];

        for(int i = 0; i< numCourses; i++){
            if(state[i] == 0) {
                if(!dfs(graph, state,i)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(List<Integer>[] graph, int[] state, int course){
        if(state[course] == 1){
            return false;
        }

        if(state[course] == 2){
            return true;
        }

        state[course] = 1;

        for (int next : graph[course]){
            if(!dfs(graph, state, next)){
                return false;
            }
        }

        state[course] = 2;

        return true;
    }
}
