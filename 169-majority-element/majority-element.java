class Solution {
    public int majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = nums.length / 2;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) > max) 
            return key;
        }

        return -1;
    }
}