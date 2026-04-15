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
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;

        if(root.val == key) return helper(root);

        TreeNode temp = root;

        while(temp != null) {

            if(temp.val > key){
                if( temp.left != null && temp.left.val == key){
                    temp.left = helper(temp.left);
                    break;
                } else {
                    temp = temp.left;
                }

            } else{
                if(temp.right != null && temp.right.val == key){
                    temp.right = helper(temp.right);
                    break;
                }else{
                    temp = temp.right; 
                }
            }
        }
        
        return root;
    }

    public TreeNode helper(TreeNode node){

        if(node.left == null) return node.right;
        else if(node.right == null) return node.left;
        else {

            TreeNode nodeRight = node.right;
            TreeNode lastRight = findLastRight(node.left);
            lastRight.right = nodeRight;
            return node.left;
        }
    }

    public TreeNode findLastRight(TreeNode node){
        if( node.right == null) return node;

        return findLastRight(node.right);
    }
}