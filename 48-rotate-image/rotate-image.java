class Solution {

    public void reverse(int[] row, int l , int r){

        while( l <= r){

            int temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            l++;
            r--;
        }
    }
    

    public void rotate(int[][] matrix) {

        //==========approach 2============
        int n = matrix.length;

        //transposing matrix
        for(int i = 0 ; i < n - 1 ; i++){

            for( int j = i+1 ; j < n ; j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reversing each row
        for(int i = 0 ; i < n ; i++){

            reverse(matrix[i], 0 , n-1);
        }

        //=============APPROACH 1(BRUTEE)==========
        // int n = matrix.length;
        // int[][] temp = new int[n][n];

        // for(int i = 0 ;i < n ; i++){

        //     for(int j = 0 ; j < n ; j++){

        //         temp[j][n-i-1] = matrix[i][j];
        //     }
        // }
        //   for(int i = 0 ;i < n ; i++){

        //     for(int j = 0 ; j < n ; j++){

        //         matrix[i][j] = temp[i][j];
        //     }
        // }
        
    }
}