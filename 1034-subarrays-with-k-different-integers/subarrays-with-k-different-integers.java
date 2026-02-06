class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        //============APPROACH 2===============
        
        return sub(nums, k) - sub(nums, k-1);

        //=============APPROACH 1================
        // int count = 0;

        // for( int i  = 0; i < nums.length ; i++){

        //     HashMap<Integer, Integer> map = new HashMap<>();

        //     for(int j = i ; j < nums.length ; j++){

        //         map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

        //         if( map.size() > k) break;

        //         if(map.size() == k) count = count + 1;
        //     }
        // }
        
        // return count;
    }


    public int sub(int[] nums, int k) {

        int l = 0 , r = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        while( r < n){

            map.put(nums[r] , map.getOrDefault(nums[r], 0) + 1);

            while( map.size() > k){
                map.put(nums[l] , map.get(nums[l]) - 1);

                if(map.get(nums[l]) == 0)
                map.remove(nums[l]);

                l++;
            }

            count = count + (r - l + 1);
            r++;
        }
        return count;
    }
}