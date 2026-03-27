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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> outerList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return outerList;

        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {

            int size = q.size();
            LinkedList<Integer> lvlOrder = new LinkedList<>();

            for(int i = 0; i < size; i++) {

                TreeNode top = q.poll();
                if(top.left != null) q.offer(top.left);
                if(top.right != null) q.offer(top.right);

                if(level % 2 == 0) lvlOrder.addLast(top.val);
                else lvlOrder.addFirst(top.val);

            }
            level++;
            outerList.add(lvlOrder);
        }

    return outerList;
    }
}