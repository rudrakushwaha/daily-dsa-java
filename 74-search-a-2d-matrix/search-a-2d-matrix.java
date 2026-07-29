class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m*n - 1;

        while(l <= r){

            int mid = l + (r - l)/2;

            //converting m to matrix coords
            int mi = mid / n;
            int mj = mid % n;

            if(matrix[mi][mj] == target){
                return true;
            } else if(matrix[mi][mj] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return false;
    }
}