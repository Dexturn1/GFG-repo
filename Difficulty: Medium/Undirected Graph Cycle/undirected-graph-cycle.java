class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i<V; i++)
            graph.add(new ArrayList<>());
    
        
        for(int i = 0; i<edges.length; i++){
            graph.get(edges[i][0] ).add(edges[i][1]);
            graph.get(edges[i][1] ).add(edges[i][0]);
        }
        
        
        boolean []Visited = new boolean[V];
        
        for(int i = 0; i<V; i++){
            
            if(!Visited[i]){
                if(bfsCheck(i, graph, Visited ))
                    return true;
    
            }
       
        }  
        return false;
    
   
    }
    
     
    boolean bfsCheck(int start, List<List<Integer>> graph, boolean []visited){
        
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visited[start] = true;
        
        while(!q.isEmpty()){
            int []pair = q.poll();
            int node = pair[0];
            int parent = pair[1];
            
            for(int neighbor: graph.get(node)){
                
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, node});
                }else if(neighbor != parent){
                    return true;
                }
                
            }
            
        }
        
        
        return false;
        
    }
    
}







