class Solution {
    public int missingNumber(int[] nums) {
        
       int[] hashmap = new int[nums.length+1];

       for(int i = 0 ; i < nums.length ; i++){

            hashmap[nums[i]] = 1;
       }

       for(int i = 0 ; i <= nums.length ; i++){

            if(hashmap[i] == 0)
            return i;
       }

       return -1;
    }
}