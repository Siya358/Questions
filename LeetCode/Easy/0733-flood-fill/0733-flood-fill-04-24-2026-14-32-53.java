class Solution {
    public class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    private boolean isSafe(int r, int c, int n, int m){
        return (r>=0 && c>=0 && r<n && c<m);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ori_col = image[sr][sc];

        if (ori_col == color) return image;
        int n = image.length;
        int m = image[0].length;

        Queue<Pair> q = new LinkedList<>();
        image[sr][sc] = color;
        q.add(new Pair(sr,sc));

        while(!q.isEmpty()){
            Pair curr = q.remove();
            int r = curr.row;
            int c = curr.col;

            int[][] dir ={{-1,0}, {1,0}, {0,1}, {0,-1}};

            for(int k =0; k<4; k++){
                int newr = r + dir[k][0];
                int newc = c + dir[k][1];
                if(isSafe(newr, newc, n, m) && image[newr][newc] == ori_col){
                    image[newr][newc] = color;
                    q.add(new Pair(newr,newc));
                }
            }

        }
        return image;
    }
}