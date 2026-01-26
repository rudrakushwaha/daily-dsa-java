class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
       char[][] board = new char[n][n];

       for(int i=0; i<n; i++){
        Arrays.fill(board[i],'.');
       }

       solve(0, board, n);

        return result;

    }

    private void solve(int col, char[][] board, int n){

        if(col == n){
            result.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++){
            
            if(isSafe(row, col, board, n)){

                board[row][col] = 'Q';
                solve(col+1, board, n);
                board[row][col] = '.';
            }
        }

    }

    private boolean isSafe(int row, int col, char[][] board, int n){

        int dupRow = row;
        int dupCol = col;
        //checking above diagonal

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        //checking left row
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;

        //checking lower left diagonal
        while( row < n && col >=0){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        return true;
    }

    private List<String> construct(char[][] board){

        List<String> list = new ArrayList<>();
        for(char[] row: board){
            list.add(new String(row));
        }
        return list;
    }
}