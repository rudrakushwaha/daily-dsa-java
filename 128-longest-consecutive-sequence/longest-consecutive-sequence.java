import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {

        // if (nums.length == 0) return 0;

        // Arrays.sort(nums);

        // int longest = 1;
        // int current = 1;

        // for (int i = 1; i < nums.length; i++) {

        //     // Duplicate
        //     if (nums[i] == nums[i - 1]) {
        //         continue;
        //     }

        //     // Consecutive
        //     else if (nums[i] == nums[i - 1] + 1) {
        //         current++;
        //     }

        //     // Gap
        //     else {
        //         current = 1;
        //     }

        //     longest = Math.max(longest, current);
        // }

        // return longest;

        //=======================optimal hashset solution================

        HashSet<Integer> set = new HashSet<>();
        int longest = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : set){

            //checking if the current number may be the start of the sequence
            if(!set.contains(num - 1)) { //if number previous to it doesn't exist -> can be the start

                int length = 1;
                int current = num;

                while( set.contains(current + 1)){
                    current++;
                    length++;
                }
            

             longest = Math.max(longest, length);
            }

        }

        return longest;
    }
}