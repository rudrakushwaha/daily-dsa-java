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

      public void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parentTrack){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode current = q.poll();

            if(current.left != null){
                parentTrack.put(current.left, current);
                q.offer(current.left);
            }
            if(current.right != null){
                parentTrack.put(current.right, current);
                q.offer(current.right);
            }

        }
    }
    public TreeNode preOrder(TreeNode node, int start){

        if(node == null) return null;
        if(node.val == start) return node;

        TreeNode left = preOrder(node.left, start);
        if(left != null) return left;
        return preOrder(node.right, start);

    }

    public int amountOfTime(TreeNode root, int start) {

         HashMap<TreeNode, TreeNode> parentTrack = new HashMap<>();

        markParents(root, parentTrack);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        //preorder traversal
        TreeNode StartNode = preOrder(root, start);

        q.offer(StartNode);
        visited.put(StartNode, true);
        int currLvl = 0;

        while(!q.isEmpty()){
            
            int size = q.size();

            currLvl++; 

            for(int i = 0 ; i< size; i++){
                TreeNode current = q.poll();

                if(current.left!= null && visited.get(current.left) == null){
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right) == null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parentTrack.get(current) != null && visited.get(parentTrack.get(current)) == null){
                    q.offer(parentTrack.get(current));
                    visited.put(parentTrack.get(current), true);
                }
            }
        }
        return currLvl - 1;
    }
}