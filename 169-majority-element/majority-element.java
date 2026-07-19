class Solution {
    public int majorityElement(int[] nums) {
        
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int max = nums.length / 2;

        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // for(int key: map.keySet()){
        //     if(map.get(key) > max) 
        //     return key;
        // }

        // return -1;


        // ===============OPTIMAL(MOORE'S VOTING) ALGO==========
        int currElem = 0;
        int count = 0;
        int max = nums.length / 2;

        for(int i = 0 ; i < nums.length ; i++){
            
            if(count == 0){
                count = 1;
                currElem = nums[i];
            } else if( currElem == nums[i]){
                count++;
            } else {
                count--;
            }
        }

       

        return currElem;
    }
}