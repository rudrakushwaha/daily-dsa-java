class Solution {
    public int subarraySum(int[] nums, int k) {
          
        int count = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        long remaining = 0;
        map.put(0L,1);

        for( int i = 0 ; i < nums.length ; i++){

            sum += nums[i];
            remaining = sum - k;

            if( map.containsKey(remaining)){
               count += map.get(remaining);
            }
             map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
		return count;
    }
}