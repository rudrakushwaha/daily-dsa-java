class Solution {
    public int findKthLargest(int[] nums, int k) {


    //    int targetIdx = nums.length - k;
    //     return quickSelect(nums, 0, nums.length - 1, targetIdx);
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for(int num : nums){
        pq.offer(num);
    }

    while(k - 1 > 0){
        pq.poll();
        k--;
    }

    return pq.peek();



    }
        
    // private int quickSelect(int[] nums, int left, int right, int targetIdx) {
    //     if (left == right) {
    //         return nums[left];
    //     }

    //     int pivot = nums[left];
    //     int low = left;
    //     int high = right;

    //     while (low <= high) {
    //         while (low <= high && nums[low] < pivot) {
    //             low++;
    //         }
    //         while (low <= high && nums[high] > pivot) {
    //             high--;
    //         }
    //         if (low <= high) {
    //             int temp = nums[low];
    //             nums[low] = nums[high];
    //             nums[high] = temp;
    //             low++;
    //             high--;
    //         }
    //     }

    //     if (targetIdx <= high) {
    //         return quickSelect(nums, left, high, targetIdx);
    //     } else if (targetIdx >= low) {
    //         return quickSelect(nums, low, right, targetIdx);
    //     } else {
    //         return nums[targetIdx];
    //     }
    // }
}