class Solution {
    public int searchInsert(int[] nums, int target) {

        int l = 0 , u = nums.length - 1, mid = 0;
        int ans = 0;

        while(l <= u){

            mid = l + (u-l)/2;

            if(target == nums[mid]) return mid;
            else if( target > nums[mid]){ 
                l = mid + 1;
                ans = l;
                 }
            else u = mid - 1;

        }

        return l;
        
    }
}