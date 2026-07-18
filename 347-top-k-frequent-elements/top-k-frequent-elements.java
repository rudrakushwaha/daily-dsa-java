class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // ===========PRIORITY QUEUE====
         HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(), b.getValue()));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){

            pq.offer(entry);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int [] result = new int[k];

        for(int i = 0 ; i < k; i++){
            result[i] = pq.poll().getKey();
        }

        return result;

        //=================BRUTE FORCE APPROACH===
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int[] result = new int[k];

        // for(int num: nums){
        //     map.put(num, map.getOrDefault(num,0)+1);
        // }
        
        // for(int i = 0 ; i < k ; i++){

        //     int maxFreq = -1;
        //     int element = -1;


        //     for(Map.Entry<Integer, Integer> entry: map.entrySet()){

        //         if(entry.getValue() > maxFreq){
        //             maxFreq = entry.getValue();
        //             element = entry.getKey();
        //         }


        //     }

        //     result[i] = element;
        //     map.remove(element);
        // }


        // return result;
    }
}