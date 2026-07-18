class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        for(int i = 0 ; i < k ; i++){

            int maxFreq = -1;
            int element = -1;


            for(Map.Entry<Integer, Integer> entry: map.entrySet()){

                if(entry.getValue() > maxFreq){
                    maxFreq = entry.getValue();
                    element = entry.getKey();
                }


            }

            result[i] = element;
            map.remove(element);
        }


        return result;
    }
}