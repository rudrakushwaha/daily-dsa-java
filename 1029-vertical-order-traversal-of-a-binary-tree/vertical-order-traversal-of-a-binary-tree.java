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
// class Tuple{

//     TreeNode node;
//     int col;
//     int row;

//     public Tuple(TreeNode _node, int _col, int _row){
//         node = _node;
//         col = _col;
//         row = _row;
//     }
// }

class Tuple{

    TreeNode node;
    int col;
    int row;

    Tuple(TreeNode _node, int _col, int _row){

        node = _node;
        col = _col;
        row = _row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {


        TreeMap< Integer, TreeMap< Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0)); 

        while(!q.isEmpty()){

            Tuple tup = q.poll();
            TreeNode node = tup.node;
            int col = tup.col;
            int row = tup.row;

            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }

            if(!map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).offer(node.val);

            if(node.left != null) {
                q.offer(new Tuple(node.left, col - 1 , row + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> outlist = new ArrayList<>();

        for( TreeMap<Integer, PriorityQueue<Integer>> innermap : map.values()){

            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : innermap.values()){

                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            outlist.add(list);
        }

        return outlist;

        
        // TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue<Tuple> q = new LinkedList<Tuple>();

        // q.offer(new Tuple(root, 0, 0));

        // while(!q.isEmpty()){

        //     Tuple tuple = q.poll();
        //     TreeNode temp = tuple.node;
        //     int v = tuple.col;
        //     int l = tuple.row;

        //     if(!map.containsKey(v)){
        //         map.put(v, new TreeMap<>());
        //     }
        //     if(!map.get(v).containsKey(l)){
        //         map.get(v).put(l, new PriorityQueue<>());
        //     }
        //     map.get(v).get(l).offer(temp.val);

        //     if(temp.left != null){
        //         q.offer(new Tuple(temp.left, v-1, l+1));
        //     }
        //     if(temp.right != null){
        //         q.offer(new Tuple(temp.right, v+1, l+1));
        //     }
        // }

        // List<List<Integer>> list = new ArrayList<>();

        // for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
        //     List<Integer> inlist = new ArrayList<>();
        //     for(PriorityQueue<Integer> nodes : ys.values()){

        //         while(!nodes.isEmpty()){
        //             inlist.add(nodes.poll());
        //         }
        //     }
        //     list.add(inlist);
        // }
        // return list;
    }
}