class Solution {
    public int[][] kClosest(int[][] points, int k) {

            int n = points.length;
    
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
           int  distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];

            return distB - distA;
    });

    //    for(int i = 0 ; i< n;i++){
           
    //        int[] point = points[i];
    //        int x2 = point[0];
    //        int y2 = point[1];

    //         pq.offer(new int[]{x2,y2});

    //         if(pq.size() > k){
    //             pq.poll();
    //         }

    //    }
         for(int[] point : points){
           

            pq.offer(point);

            if(pq.size() > k){
                pq.poll();
            }

       }

       int[][] result = new int[k][2];

       for(int i = 0 ; i < k; i++){
        result[i] = pq.poll();
       }

    //    return pq.toArray(new int[pq.size()][]);
        return result;
    }
}