class Solution {
    public int numIslands(char[][] grid) {

        // int m = grid.length;
        // int n = grid[0].length;
        // char[][] visited =  new char[m][n];
        // int count =0;

        // for(int i = 0 ;i < m ; i++){
        //     for(int j= 0; j < n ; j++){

        //         // if there starts a island and it is not visited
        //         if(grid[i][j] == '1' && visited[i][j] != '1'){
        //             bfs(grid, i, j, m, n, visited);
        //             count++;
        //         }
        //     }
        // }

        // return count;

        int m = grid.length;
        int n = grid[0].length;
        char[][] visited = new char[m][n];
        int count = 0;

        for(int i = 0 ; i < m; i++){
            for(int j =0 ; j < n ; j++){

                if(grid[i][j] == '1' && visited[i][j] != '1'){
                    bfs(grid, i, j, visited, m , n );
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(char[][] grid, int i, int j, char[][] visited, int row, int col){

        Queue<int []> q = new LinkedList<>();
        visited[i][j] = '1';
        q.offer(new int[]{i,j});

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){

            int size = q.size();

            for(int it = 0 ; it < q.size() ; it++){

                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];

                for(int k = 0 ; k < 4; k++){

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == '1' && visited[nr][nc] != '1'){
                        visited[nr][nc] = '1';
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

    }

    // public void bfs(char[][] grid, int i, int j, int row, int col, char[][] visited){

    //     int[] dr = {-1,0,1,0};
    //     int[] dc = {0,1,0,-1};

    //     Queue<int []> q = new LinkedList<>();
    //     q.offer(new int[]{i,j});
    //     visited[i][j] = '1';

    //     while(!q.isEmpty()){

    //         int size = q.size();

    //         for(int it = 0 ; it < size ; it++){

    //             int[] cell = q.poll();
    //             int r = cell[0];
    //             int c = cell[1];

    //             for(int k = 0 ; k < 4 ; k++){

    //                 int nr = r + dr[k];
    //                 int nc = c + dc[k];

    //                 if(nr >= 0 && nr < row && 
    //                     nc >= 0 && nc < col &&
    //                         grid[nr][nc] == '1' && visited[nr][nc] != '1'){

    //                             visited[nr][nc] = '1';
    //                             q.offer(new int[]{nr,nc});
    //                         }
    //             }
    //         }
          
    //     }


    
}