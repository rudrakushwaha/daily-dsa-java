/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        findPath(root , res, new ArrayList<>());
        return res;
    
    }

    public void findPath(TreeNode node, List<String> res, List<Integer> currList )
    {
        if(node == null) return;

        currList.add(node.val);

        if(isLeaf(node)){
            String result = "";
            for(int i = 0 ; i < currList.size() ; i++){
                 
                if( i < currList.size() - 1)
                result = result + currList.get(i) + "->";
                else 
                result = result + currList.get(i);
            }
            res.add(result);
            currList.remove(currList.size()-1);
            return;
        }

        findPath(node.left, res, currList);
        findPath(node.right, res, currList);

        currList.remove(currList.size()-1);
    }

}