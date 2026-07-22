class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        //brute force solution
        // List<List<Integer>> outerList = new ArrayList<>();
        // Set<List<Integer>> set = new HashSet<>();

        // for (int i = 0 ; i< nums.length - 2 ; i++) {

        //     for(int j = i+1; j < nums.length -1 ; j++) {

        //         for(int k = j+1; k < nums.length ; k++) {

        //             if (nums[i] + nums[j] + nums[k] == 0)
        //             {
        //                 List<Integer> triplet =Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(triplet);
        //                 set.add(triplet);
        //             }
        //         }
        //     }
        // }

        // outerList.addAll(set);
        // return outerList;


        //=======================Better===================

        // List<List<Integer>> list = new ArrayList<>();
        // HashSet<List<Integer>> set = new HashSet<>();

        // for(int i = 0 ; i < nums.length - 1; i++){

        //     HashSet<Integer> hashset = new HashSet<>();
        //     for(int j = i+1 ; j< nums.length; j++){

        //             int k = - (nums[i] + nums[j]);

        //             if(hashset.contains(k)){

        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], k);
        //                 Collections.sort(triplet);
        //                 set.add(triplet);
        //             }
        //             hashset.add(nums[j]);
                
        //     }
        // }
        // list.addAll(set);
        // return list;


        //===========================OPTIMAL 2 POINTER================
        List<List<Integer>> outList =  new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){

            int l = i + 1;
            int r = nums.length - 1;

            if( i > 0 && nums[i] == nums[i-1]) continue;

            while(l < r){

                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0)
                {   
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    outList.add(list);
                    l++;
                    r--;
                    //move l and make sure l doesn't repeat
                    while( l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                    //move r and make sure r doesn't repeat
                    while(l < r && nums[r] == nums[r+1]){
                        r--;
                    }


                }
                else if( sum < 0 ){

                        l++;
                } 
                else{
                    r--;

                }
                
            }

            
        }
        return outList;

        //optimal solution
        // List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums);

        // for (int i = 0 ; i < nums.length - 2 ; i++) {

        //     int l = i + 1;
        //     int r = nums.length - 1;
            
        //     //skip duplicates elements of i
        //     if( i > 0 && nums[i] == nums[i-1]) continue;

        //     while (l < r) {

        //         int sum = nums[i] + nums[l] + nums[r];

        //         if(sum == 0) {
        //             list.add(Arrays.asList(nums[i], nums[l],nums[r]));
        //             l++;
        //             r--;

                    
        //             while(l < r && nums[l] == nums[l-1]) {
        //                 l++;
        //             }

                    
        //              while(l < r && nums[r] == nums[r+1]) {
        //                 r--;
        //             }

        //         }
        //         else if (sum < 0) {
        //             l++;

        //         }
        //         else {
        //             r--;

        //         }
        //     }
        // }

        // return list;
    }
}