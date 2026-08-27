class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) { 
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            graph.add(new ArrayList<>());
        }
        
        
        
        for(int []edge: edges){
            
            graph.get(edge[0]).add(edge[1]);
            
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[] visited = new boolean[V];
        
        visited[src] = true;
        
        q.add(new int[]{src, 0});
        
        
        while(!q.isEmpty()){
            
            int []pair = q.poll();
            int node = pair[0];
            int wt = pair[1];
            
            
            if(node == dest){
                return wt;
            }
            
            
            for(int neighbor: graph.get(node)){
                
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, wt+1});
                }
                
            }
            
        }
        
        
        
        return -1;

    }
}