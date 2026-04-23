class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];

            graph[src].add(new Edge(src, dest));
            graph[dest].add(new Edge(dest, src)); // undirected
        }

        boolean visited[] = new boolean[n];

        return helper(graph, source, destination, visited);
    }

    public boolean helper(ArrayList<Edge> graph[], int src, int dest, boolean visited[]){
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);

            if(!visited[e.dest] && helper(graph, e.dest, dest, visited)){
                return true;
            }
        }

        return false;
    }

    public class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
}