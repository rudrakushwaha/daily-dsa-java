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

    private int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        // int[] maxValue = new int[1];
        // maxValue[0] = Integer.MIN_VALUE;
        // calcMaxPathSum(root, maxValue);
        // return maxValue[0]; 
        calcMaxPathSum1(root);
        return maxPath;
    }

    // public int calcMaxPathSum(TreeNode root, int[] maxi){

    //     if(root == null) return 0;

    //     int leftSum = Math.max(0, calcMaxPathSum(root.left, maxi));
    //     int rightSum = Math.max(0, calcMaxPathSum(root.right, maxi));

    //     maxi[0] = Math.max(maxi[0], leftSum + rightSum + root.val);

    //     return root.val + Math.max(leftSum, rightSum);
    // }

    public int calcMaxPathSum1(TreeNode root){

        if(root == null) return 0;

        int leftSum = Math.max(0, calcMaxPathSum1(root.left));
        int rightSum = Math.max(0, calcMaxPathSum1(root.right));

        maxPath = Math.max(maxPath , rightSum + leftSum + root.val);

        return root.val + Math.max(leftSum, rightSum);
    }
}