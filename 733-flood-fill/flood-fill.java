class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

         int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;

        

        for(int i = 0 ; i < m; i++){
            for(int j =0 ; j < n ; j++){
                 bfs(image, sr, sc, visited, m , n, color );
            }
        }
        

        return image;
        
    }

     public void bfs(int[][] image, int sr, int sc, boolean[][] visited, int row, int col, int color){

        Queue<int[]> q = new LinkedList<>();
        visited[sr][sc] = true;
        q.offer(new int[]{sr,sc});

        int oldColor = image[sr][sc];

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){

            int size = q.size();

            for(int it = 0 ; it < size ; it++){

                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                image[r][c] = color;

                for(int k = 0 ; k < 4; k++){

                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if(nr >= 0 && nr < row && nc >= 0 && nc < col && image[nr][nc] == oldColor && !visited[nr][nc]){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

    }


}