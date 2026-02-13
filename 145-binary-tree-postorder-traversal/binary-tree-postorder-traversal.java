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
    public List<Integer> postorderTraversal(TreeNode root) {

        // List<Integer> list = new ArrayList<>();
        // Stack<TreeNode> st = new Stack<>();

        // if(root == null) return list;
        // TreeNode node = root;
        // TreeNode temp;

        // while(!st.isEmpty() || node != null){

        //     if(node != null){
        //         st.push(node);
        //         node = node.left;
        //     }
        //     else{
        //         temp = st.peek().right;
        //         if(temp == null){
        //             temp = st.peek();
        //             st.pop();
        //             list.add(temp.val);

        //             while(!st.isEmpty() && temp == st.peek().right){
        //                 temp = st.peek();
        //                 st.pop();
        //                 list.add(temp.val);
        //             }
        //         }
        //         else{
        //             node = temp;
        //         }
        //     }

        // }

        // return list;


        // using 2 stack
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;

        st1.push(root);

        while(!st1.isEmpty()) {

            TreeNode node = st1.pop();

            st2.push(node.val);

            if(node.left != null) st1.push(node.left);
            if(node.right != null) st1.push(node.right);
        }

        while(!st2.isEmpty()) result.add(st2.pop());

        return result;
         
    }
}