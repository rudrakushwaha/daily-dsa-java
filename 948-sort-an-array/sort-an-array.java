class Solution {
    public int[] sortArray(int[] nums) {
        
        int[] temp = new int[nums.length];
         mergeSort(nums, 0, nums.length - 1, temp);

         return nums;
    }

    public void mergeSort( int[] nums, int low, int high, int[] temp){

        if(low >= high) return;
        int mid = low + (high - low)/2;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid+1, high, temp);

        //this commented line is for optimization to skip merge sort if the arrays are sorted..beats 96%
        // if(nums[mid] <= nums[mid+1]) return;
        merge(nums, low, mid, high, temp);
    }

    public void merge(int[] nums, int low, int mid, int high, int[] temp) {

        int left = low;
        int right = mid + 1;
        int k= low;

        while (left <= mid && right <= high){

            if(nums[left] <= nums[right]){
                temp[k++] = nums[left++];
            }
            else {
                temp[k++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[k++] = nums[left++];

        }

        while(right <= high){
            temp[k++] = nums[right++];

        }

        for(int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }
}