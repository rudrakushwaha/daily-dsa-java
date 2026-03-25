class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();

        recur(nums,0, list, new ArrayList<>());
        return list;
    }

    public void recur(int[] nums, int index, List<List<Integer>> outlist, List<Integer> currList){

        if( index >= nums.length){
            outlist.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[index]);
        recur(nums, index + 1, outlist, currList);
        currList.remove(currList.size() - 1);
        recur(nums, index + 1, outlist, currList);
    }
}