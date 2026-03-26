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

    private int maxCount = 0;

    public int maxDepth(TreeNode root) {

        countMaxDepth(root, 0);

        return maxCount;
    }

    public void countMaxDepth(TreeNode root, int counth){

        if(root == null) return;

        counth++;
        maxCount = Math.max(maxCount, counth );

        countMaxDepth(root.left, counth);
        countMaxDepth(root.right, counth);
    
    }

   
}