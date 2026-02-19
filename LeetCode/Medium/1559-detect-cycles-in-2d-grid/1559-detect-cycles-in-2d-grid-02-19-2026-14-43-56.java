class Solution {
    class Pair {
        int r;
        int c, parr, pc;
        Pair(int r, int c, int parr, int pc) {
            this.r = r;
            this.c = c;
            this.parr = parr;
            this.pc = pc;
        }
    }
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    if (bfs(grid, i, j, vis))
                     return true;
                }
            }
        }
        return false;
    }
    public boolean bfs(char[][] grid, int sr, int sc, boolean[][] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr, sc, 0, 0));
        vis[sr][sc] = true;
        char ch = grid[sr][sc];
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int k = 0; k < 4; k++) {
                int newr = curr.r + dr[k];
                int newc = curr.c + dc[k];
                if (newr < 0 || newc < 0 || newr >= grid.length || newc >= grid[0].length){
                     continue;
                }
                if (grid[newr][newc] != ch) continue;
                if (!vis[newr][newc]) {
                    vis[newr][newc] = true;
                    q.offer(new Pair(newr, newc, curr.r, curr.c));
                }
                else if (newr != curr.parr || newc != curr.pc) {
                    return true;
                }
            }
        }
        return false;
    }
}