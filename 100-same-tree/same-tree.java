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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if((p == null ||  q==null)) return p == q;
        else if(p.val != q.val) return false;

        boolean leftCheck = isSameTree(p.left, q.left);
        boolean rightCheck = isSameTree(p.right, q.right);

        return leftCheck & rightCheck; 

        //short code
    //   if ( p == null || q == null) return p==q ;
    //   if ( p.val != q.val) return false;

    //   return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 


    }
}