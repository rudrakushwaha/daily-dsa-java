class Solution {
    public int findCircleNum(int[][] isConnected) {

        int count = 0;
        
        int n = isConnected.length ;
        boolean[] vis = new boolean[n];


        //converting matrix to adjency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j <n ; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){

            if(!vis[i]){  //if not visited
            count++;
                dfs(i, adj, vis);
            }
        }

        return count;
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        
        visited[node] = true;
        
        for(int neighbour: adj.get(node)){
            
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }
}