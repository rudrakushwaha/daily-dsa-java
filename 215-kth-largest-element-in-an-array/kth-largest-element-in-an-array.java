class Solution {
    public int findKthLargest(int[] nums, int k) {

        //optimal approach using quick sort
       int targetIdx = nums.length - k;


        return quickSelect(nums, 0, nums.length - 1, targetIdx);


    ////////////////BETTER APPROACH WITH O(nlogk)
    // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    // for(int num : nums){
    //     pq.offer(num);
    // }

    // while(k - 1 > 0){
    //     pq.poll();
    //     k--;
    // }

    // return pq.peek();



    }
        
    private int quickSelect(int[] nums, int low, int high, int targetIdx) {

        if (low > high)
            return -1;
        
        int pIndex = partitionIndex(nums, low, high, targetIdx);

        if(pIndex == targetIdx){
            return nums[pIndex];
        }

        if(pIndex > targetIdx){
            //sort left
           return quickSelect(nums, low, pIndex-1, targetIdx);
        } 
   
        return quickSelect(nums, pIndex + 1, high, targetIdx);
    }

    public int partitionIndex(int[] nums, int low, int high, int targetIdx) {

        int pivot = nums[low];
        int i = low; 
        int j = high;

        while( i < j){

            while( i < high && nums[i] <= pivot){
                i++;
            }

            while( j > low && nums[j] > pivot){
                j --;
            }

            if(i < j){
                swap(nums, i, j);
            }
        }
        swap(nums, low, j);
        return j;

    }

    public void swap(int[] nums, int i, int j){

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
        
}