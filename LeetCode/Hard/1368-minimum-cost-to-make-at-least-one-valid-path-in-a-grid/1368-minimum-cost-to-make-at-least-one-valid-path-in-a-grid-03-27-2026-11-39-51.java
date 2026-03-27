class Solution {
    class Pair {
        int row, col, cost;
        Pair(int r, int c, int cost) {
            this.row = r;
            this.col = c;
            this.cost = cost;
        }
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int minCost(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Pair(0, 0, 0));
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.row, c = curr.col, cost = curr.cost;
            if (r == m - 1 && c == n - 1) return cost;
            if (cost > dist[r][c]) continue;
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int newCost = cost + (grid[r][c] == i + 1 ? 0 : 1);
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.add(new Pair(nr, nc, newCost));
                }
            }
        }

        return -1;
    }
}