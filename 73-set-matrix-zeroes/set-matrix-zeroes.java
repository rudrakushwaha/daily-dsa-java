class Solution {
    public void setZeroes(int[][] matrix) {
        

        HashMap<Integer, Integer>  mapR= new HashMap<>();
        HashMap<Integer, Integer>  mapC= new HashMap<>();

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                    if(matrix[i][j] == 0){
                        mapR.put(i, 1);
                        mapC.put(j, 1);
                    }
            }
        }

        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                
                if(mapR.containsKey(i) || mapC.containsKey(j) ){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}