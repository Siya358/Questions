class Solution {
    public class Edge{
        int src;
        int des;
        public Edge(int src, int des){
            this.src = src;
            this.des = des;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0; i<edges.length; i++){
            int src = edges[i][0];
            int des = edges[i][1];
            graph[src].add(new Edge(src, des));
            graph[des].add(new Edge(des, src));


        }
        boolean[] vis= new boolean[n];
        
        

        Queue<Integer> q =new LinkedList<>();
        q.add(source);
        vis[source] = true;

        while(!q.isEmpty()){
            int curr = q.remove();
            if (curr == destination) return true;
            for(Edge e : graph[curr]){
                int neighbour = e.des;
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }
        return false;

        
    }
}