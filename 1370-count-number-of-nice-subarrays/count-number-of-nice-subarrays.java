class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        //==============APPPROACH 2==================

        return subArrCount(nums, k) - subArrCount(nums, k - 1);


        //==============APPROACH 1 (BRUTE)==============
        // int oddCount = 0;
        // int count = 0;

        // for( int i = 0; i < nums.length; i++){
        //     oddCount = 0;
        //     for(int j = i; j < nums.length; j++){
        //         if( nums[j] % 2 != 0) oddCount++;

        //         if( oddCount == k) {
        //             count++;
        //         }
        //     }
        // }

        // return count;
    }

    public int subArrCount(int[] nums , int goal) {

        if ( goal < 0) return 0;

        int l = 0, r = 0;
        int count = 0;
        int n = nums.length;
        int sum = 0;

        while( r < n){

            sum += (nums[r] % 2);

            while( sum > goal){
                sum -= (nums[l] % 2);
                l += 1;
            }
            count += (r - l + 1);

            r++;

        }

        return count;
    }
}