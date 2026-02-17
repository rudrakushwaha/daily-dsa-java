class Solution {
    public int removeDuplicates(int[] nums) {


        //===============APPROACH 1///////////////
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int index = 0;
        for(Integer it: set){
            nums[index] = it;
            index++;
        }

        return index;
        
        //=============AROAFCH 2=================OPTIMAL
        // int i = 0;

        // for(int j= 1 ; j< nums.length ; j++){

        //     if(nums[j] != nums[i]){
        //         i++;
        //         nums[i] = nums[j];
        //     }
        // }

        // return i+1;
        
    }
}