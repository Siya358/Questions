class Solution {

    int dx[]= {0,0,-1,1};
    int dy[]={1,-1,0,0};

    class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public boolean isValid(int r,int c,int n,int m){
        return r>=0 && r<n && c>=0 && c<m;
    }

    public int bfs(int r,int c ,int[][] grid,boolean[][] visited){
        int n=grid.length;
        int m=grid[0].length;

        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(r,c));
        visited[r][c]=true;

        int ans=0;

        while(!q.isEmpty()){
            Pair curr=q.poll();
            int cr=curr.row;
            int cc=curr.col;

            ans += 4;

            for(int i=0;i<4;i++){
                int nr=cr+dx[i];
                int nc=cc+dy[i];

                if(isValid(nr,nc,n,m) && grid[nr][nc]==1){
                    ans--; // shared edge

                    if(!visited[nr][nc]){
                        visited[nr][nc]=true;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }

        return ans;
    }

    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean [][] visited= new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return bfs(i,j,grid,visited);
                }
            }
        }

        return 0;
    }
}