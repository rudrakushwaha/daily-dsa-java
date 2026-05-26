class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // brute force
        // int i1 = 0 , i2 = 0;
        // boolean found = false;

        // for(int i = 0 ; i< nums.length - 1; i++){
        //     for(int j = i+1 ; j < nums.length ; j++) {

        //         int sum = 0;
        //         sum = nums[i] + nums[j];
        //         if(sum == target) {
        //             i1 = i;
        //             i2 = j;
        //             found = true;
        //             break;
        //         }
        //     }
        //     if (found) break;
        // }

        // return new int[]{i1,i2};


        //using 2 pointers

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i< nums.length ; i++) {

            int compliment = target - nums[i];

            if(map.containsKey(compliment)) {
                return new int[]{i , map.get(compliment)};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}