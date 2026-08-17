class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int maxCount = 0;

        int[][] visited = new int[m][n];

        for(int i = 0 ; i < m ; i++){

            for(int j = 0 ; j< n ; j++){

                if(grid[i][j] == 1 && visited[i][j] != 1){
                    int cc = bfs(grid,m,n,visited, i, j, count);
                    maxCount = Math.max(cc, maxCount);
                    count = 0;
                }
            }
        }
        return maxCount;
        
    }

    public int bfs(int[][] grid, int row, int col, int[][] visited, int i, int j, int count){

        Queue<int[]> q = new LinkedList<>();
        visited[i][j] = 1;
        count++;

        q.offer(new int[]{i,j});

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1,0,-1};

        while(!q.isEmpty()){

            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for(int k = 0 ; k < 4; k++){

                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1 && visited[nr][nc] != 1){
                    visited[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }

        return count;
    }
}