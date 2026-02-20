class Solution {
    public int singleNumber(int[] nums) {

        ///===========APPROACH 3 (BETTER APPROACH)==============
        

        //===============APPROACH 2 brute force===============
        // int count = 0;
        // for(int i  = 0 ; i < nums.length ; i++){
        //     int num = nums[i];
        //     count = 0;
        //     for(int j = 0 ; j < nums.length ; j++){

        //         if(nums[j] == num) count++;
        //     }

        //     if(count == 1) return nums[i];
        // }
        // return 0;
        //===============APPROACH 1=================
        int xor = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            xor = xor ^ nums[i];
        }

        return xor;
    }
}