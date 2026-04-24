class Solution {
    private boolean isSafe(int r, int c, int m, int n){
        return (r>= 0 && c>=0 && r<m && c<n);
    }
    public void floodfill(int r, int c, int m,int n, char[][] board){
        board[r][c] = 'V';
        int[][] dir = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
        for(int k =0; k<4; k++){
            int newr = r+ dir[k][0];
            int newc = c+ dir[k][1];
            if(isSafe(newr, newc, m,n)&& board[newr][newc] == 'O' )
            floodfill(newr, newc, m,n, board);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // to chnage boundry 0 to v
        for(int j =0; j<n; j++){
            if(board[0][j] == 'O') floodfill(0,j, m, n, board);
            if(board[m-1][j] == 'O') floodfill(m-1, j, m, n, board);

        }
        for(int i =0; i<m; i++){
            if(board[i][0] == 'O' )floodfill(i,0, m,n , board);
            if(board[i][n-1] == 'O') floodfill(i, n-1, m, n, board);
        }



        // change rest 0 to x

        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
        // change v to again 0
        for(int i =0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'V') board[i][j] = 'O';
            }
        }
        
    }
}