class Solution {
    public void setZeroes(int[][] matrix) {
        

        // =============IN PLACE============

        int col0 = 1;
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                
                if(matrix[i][j] == 0){

                    //mark ith row as 0
                    matrix[i][0] = 0;

                    //mark jth col as 0, excluding oth col
                    if(j != 0){
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 1 ; j < matrix[0].length ; j++){

                if(matrix[i][j] != 0){

                        if(matrix[i][0] == 0 || matrix[0][j] == 0){
                            matrix[i][j] = 0;
                        }
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0 ; j < matrix[0].length ; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i = 0 ; i < matrix.length ; i++){
                matrix[i][0] = 0;
            }
        }

    



        //=============SOLN 1 but with O(2N) space comp.
        // HashMap<Integer, Integer>  mapR= new HashMap<>();
        // HashMap<Integer, Integer>  mapC= new HashMap<>();

        // for(int i = 0 ; i < matrix.length ; i++){
        //     for(int j = 0 ; j < matrix[0].length ; j++){
        //             if(matrix[i][j] == 0){
        //                 mapR.put(i, 1);
        //                 mapC.put(j, 1);
        //             }
        //     }
        // }

        // for(int i = 0 ; i < matrix.length ; i++){
        //     for(int j = 0 ; j < matrix[0].length ; j++){
                
        //         if(mapR.containsKey(i) || mapC.containsKey(j) ){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }

    }
}