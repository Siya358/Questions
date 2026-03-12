class Solution {

    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++)
                parent[i] = i;
        }

        int find(int x){
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a,int b){
            int pa = find(a);
            int pb = find(b);

            if(pa == pb) return;

            if(rank[pa] < rank[pb])
                parent[pa] = pb;
            else if(rank[pb] < rank[pa])
                parent[pb] = pa;
            else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);

        int q = queries.length;
        int[][] newQueries = new int[q][4];

        for(int i=0;i<q;i++){
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = queries[i][2];
            newQueries[i][3] = i;
        }

        Arrays.sort(newQueries,(a,b)->a[2]-b[2]);

        DSU dsu = new DSU(n);
        boolean[] ans = new boolean[q];

        int i = 0;

        for(int[] query : newQueries){

            int p = query[0];
            int qnode = query[1];
            int limit = query[2];
            int idx = query[3];

            while(i < edgeList.length && edgeList[i][2] < limit){
                dsu.union(edgeList[i][0], edgeList[i][1]);
                i++;
            }

            ans[idx] = dsu.find(p) == dsu.find(qnode);
        }

        return ans;
    }
}