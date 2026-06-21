class Solution {
    public int majorityElement(int[] nums) {
        
        int max = nums.length/2;

        for(int i = 0 ; i < nums.length ; i++){
            int currElem = nums[i];
            int count = 0;
            for(int j = 0 ; j < nums.length ; j++){

                if(currElem == nums[j]){
                    count++;
                }
            }
            if(count > max){
                return currElem;
            }
        }
        return -1;
    }
}