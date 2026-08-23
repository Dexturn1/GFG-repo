class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i< V; i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i<edges.length; i++){
            
            graph.get(edges[i][0]).add(edges[i][1]);
            
        }
        
        
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        
        for(int i= 0; i<V; i++){
            
            if(vis[i] == 0){
                if(dfsCheck(i, graph, vis, pathVis))
                    return true;
            }
            
        }
        
        return false;
    }
    
    
    boolean dfsCheck(int node, List<List<Integer>> graph, int[]vis, int[] pathVis){
        
        vis[node] = 1;
        pathVis[node] = 1;
        
        
        // traverse for ajd nodes
        for(int neighbor: graph.get(node)){
            
            if(vis[neighbor] == 0){
                if(dfsCheck(neighbor, graph, vis, pathVis))
                    return true;
            }else if(pathVis[neighbor] == 1){
                return true;
                
            }
        }
        
        
        pathVis[node] = 0;
        return false;
        
    }
}











