class Solution {
    public int leastInterval(char[] tasks, int n) {

        //counting frequencies
        int[] freq = new int[26];

        for(char task: tasks){
            freq[task - 'A']++;
        }

        //step 2: MAX HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f: freq){

            if(f > 0)
                pq.offer(f);
        }

        int time = 0;

        //step: 3 process tasks
        while(!pq.isEmpty()){

            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            while(cycle > 0 && !pq.isEmpty()){

                int count = pq.poll();

                count--;

                if(count > 0){
                    temp.add(count);
                }

                time++;
                cycle--;
            }

            //put remaining tasks back into heap
            for(int count: temp){
                pq.offer(count);
            }

            //add idle time only if the work is still left
            if(!pq.isEmpty()){
                time += cycle;
            }
        }

        return time;
        
    }
}