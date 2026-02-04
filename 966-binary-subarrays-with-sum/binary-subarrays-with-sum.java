class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        //================APPROACH 2=================
         int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        long remaining = 0;
        map.put(0L,1);

        for( int i = 0 ; i < nums.length ; i++){

            sum += nums[i];
            remaining = sum - goal;

            if( map.containsKey(remaining)){
               count += map.get(remaining);
            }
             map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
		return count;
        
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
}