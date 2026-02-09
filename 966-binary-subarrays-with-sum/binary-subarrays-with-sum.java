class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        //================APPROACH 3======================
        //algo which count sum <= k 
        return subArrCount(nums, goal) - subArrCount(nums, goal - 1);

        //================APPROACH 2 (similar to longest sub with sum k and count subarray with sum k)=================
        //  int count = 0;
        // HashMap<Long, Integer> map = new HashMap<>();
        // long sum = 0;
        // long remaining = 0;
        // map.put(0L,1);

        // for( int i = 0 ; i < nums.length ; i++){

        //     sum += nums[i];
        //     remaining = sum - goal;

        //     if( map.containsKey(remaining)){
        //        count += map.get(remaining);
        //     }
        //      map.put(sum, map.getOrDefault(sum, 0) + 1);

        // }
		// return count;
        
        //==================APPROACH 1==================
        // int count = 0;
        // int sum = 0;

        // for( int i = 0; i < nums.length ; i++){
        //     sum = 0;
        //     for(int j = i; j < nums.length ; j++){

        //         sum += nums[j];
        //         if(sum == goal) count++;
        //         else if( sum > goal) break;
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

            sum += nums[r];

            while( sum > goal){
                sum -= nums[l];
                l += 1;
            }
            count += (r - l + 1);

            r++;

        }

        return count;
    }
}