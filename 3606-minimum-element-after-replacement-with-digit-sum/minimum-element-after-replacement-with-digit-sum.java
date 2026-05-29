class Solution {
    public int minElement(int[] nums) {

        for(int i = 0 ; i < nums.length ; i++){

            int n = nums[i];
            int sum = 0;
            
            while(n != 0){
                int d = n % 10;
                sum +=  d;
                n = n/10;
            }

            nums[i] = sum;
        }

        int min = nums[0];
        for(int n : nums){
             if(n < min){
                min = n;
             }
        }

        return min;
    }
}