import java.util.*;

class Solution {

    class Pair {
        int row, col, dist;
        Pair(int r, int c, int d) {
            this.row = r;
            this.col = c;
            this.dist = d;
        }
    }

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(entrance[0], entrance[1], 0));
        visited[entrance[0]][entrance[1]] = true;

        int[] drow = {0, 0, 1, -1};
        int[] dcol = {1, -1, 0, 0};

        while (!queue.isEmpty()) {

            Pair curr = queue.poll();

            int r = curr.row;
            int c = curr.col;
            int d = curr.dist;

            if ((r == 0 || c == 0 || r == m - 1 || c == n - 1) &&
                !(r == entrance[0] && c == entrance[1])) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    maze[nr][nc] == '.' &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc, d + 1));
                }
            }
        }

        return -1;
    }
}