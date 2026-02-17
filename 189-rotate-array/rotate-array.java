class Solution {
    public void rotate(int[] nums, int k) {
            //=========APPROACH 2===============
            int n = nums.length;
            if( n <= 1) return;
            if(k >= n) k = k % n;

            reverse(nums, 0, n-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, n-1);
            

//==============APPROACH 1 BRUTE FORCE)================
//         int n = nums.length;
//         if( n < 1) return;

//         if( k > n) {
//             k = k % n;
//         }

//    for(int j = 1; j <= k ; j++) {
//         int temp = nums[n-1];
//         for(int i = n-1 ; i >= 1; i--){
//                 nums[i] = nums[i-1];
//         }
//         nums[0] = temp;
//    }
        
    }

    public void reverse(int[] nums, int left, int right){

        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}