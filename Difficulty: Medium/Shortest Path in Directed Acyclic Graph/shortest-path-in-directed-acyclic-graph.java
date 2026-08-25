
class Solution {

    public ArrayList<Integer> shortestPath(int V, int[][] edges) {
        
        // 1. Build adjacency list: adj[u] = List of [v, weight]
        List<List<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
        }


        // 2. Find Topological Sort order using DFS
        boolean[] visited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }
        

        // 3. Initialize distances with infinity
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[0] = 0;

        // 4. Relax edges in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();

            if (dist[u] != (int) 1e9) {
                
                for (int[] edge : adj.get(u)) {
                    int v = edge[0];
                    int wt = edge[1];
                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        // 5. Prepare final result (-1 for unreachable vertices)
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) {
                result.add(-1);
            } else {
                result.add(dist[i]); 
            }
        }

        return result;
    }
    
      private void topoSort(int node, List<List<int[]>> adj, boolean[] visited, Deque<Integer> stack) {
          
        visited[node] = true;
        
        for (int[] edge : adj.get(node)) {
            
            int neighbor = edge[0];
            
            if (!visited[neighbor]) {
                topoSort(neighbor, adj, visited, stack);
            }
        }
        stack.push(node);
        
    }
}