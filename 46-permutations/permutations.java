class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> outList = new ArrayList<>();
        boolean[] boolArr = new boolean[nums.length];
        recurPermute(nums, outList, new ArrayList<>(), boolArr);

        return outList;
    }

    void recurPermute(int[] nums, List<List<Integer>> outList,List<Integer> permute, boolean[] boolArr){

        if(permute.size() == nums.length){
            outList.add(new ArrayList<>(permute));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(!boolArr[i]){

                boolArr[i] = true;
                permute.add(nums[i]);
                recurPermute(nums, outList, permute, boolArr);
                boolArr[i] = false;
                permute.remove(permute.size()-1);
            }
        }
    }
}