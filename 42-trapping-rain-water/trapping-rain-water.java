class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        int total = 0;

        preMax[0] = height[0];
        for(int i =1; i < n ; i++){
            preMax[i] =  Math.max(preMax[i-1], height[i]);
        }
        sufMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0 ; i--){
            sufMax[i] =  Math.max(sufMax[i+1], height[i]);
        }

        for(int i = 0 ; i < n ; i++)
        {
            //if the current height is smaller than both previous and next building then there can be water
            if(height[i] < preMax[i] && height[i] < sufMax[i]){
                total += Math.min(preMax[i] , sufMax[i]) - height[i];
            }
        }

        return total;
    }
}