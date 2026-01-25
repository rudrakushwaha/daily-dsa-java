class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> outList = new ArrayList<>();

        helper(0, candidates, target, outList, new ArrayList<>());

        return outList;
    }

    void helper(int index, int[] candidates, int target, List<List<Integer>> outList, List<Integer> inList) {

        if(target == 0){
                    outList.add(new ArrayList<>(inList));
                    return;
        }

        if(index == candidates.length){
                return;
        }
        inList.add(candidates[index]);
        //pick
        if( candidates[index] <= target) {
        helper(index, candidates, target - candidates[index], outList, inList);
        }

        inList.remove(inList.size()-1);
        //not-pick
        helper(index+1, candidates, target, outList, inList);

    }
}