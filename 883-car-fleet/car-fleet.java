class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

       
        int n  = position.length;
        double[] time = new double[n];

        //to store car positions along with speed , as to track speed as we are going to sort positions
        int[][] cars = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];

        }

        //sorting by positions from near to far
         Arrays.sort(cars, (a,b) -> b[0] - a[0]);
        

        for(int i = 0 ; i < n; i++){
            time[i] = (double)(target - cars[i][0]) / cars[i][1];
        }

        double prevFleetTime = time[0];
        int countFleet = 1;

      

        for(int i = 1; i < n ; i++){

            double currentTime = time[i];
         

            if(currentTime <= prevFleetTime){
                continue;
            } else if(currentTime > prevFleetTime){
                prevFleetTime = time[i];
                countFleet++;
            }

        }
        return countFleet;
        
    }
}