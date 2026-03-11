class Solution {

    class DSU{
        int[] p;

        public DSU(int n){
            p = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = i;
            }
        }

        public int find(int x){
            if(p[x] == x) return x;
            return p[x] = find(p[x]);
        }

        public boolean union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return true; // cycle found

            p[pb] = pa;
            return false;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        DSU dsu = new DSU(n + 1);

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(dsu.union(u, v)){
                return edges[i];
            }
        }

        return new int[0];
    }
}