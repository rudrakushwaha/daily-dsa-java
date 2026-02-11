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
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        List<Integer> result = new ArrayList<>();
        st.push(root);
        while(!st.isEmpty()){

            TreeNode preElement = st.pop();
            result.add(preElement.val);

            if(preElement.right != null) st.push(preElement.right);
            if(preElement.left != null) st.push(preElement.left);
        }
        
        return result;
    }
}