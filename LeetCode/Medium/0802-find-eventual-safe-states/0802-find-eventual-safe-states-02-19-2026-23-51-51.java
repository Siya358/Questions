class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;

            for (int j = 0; j < graph[i].length; j++) {
                int v = graph[i][j];
                rev.get(v).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }
        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            ArrayList<Integer> list = rev.get(node);
            for (int i = 0; i < list.size(); i++) {
                int prev = list.get(i);
                outdegree[prev]--;

                if (outdegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}