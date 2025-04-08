/*Given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u,v] represents the edge between the vertices u and v. Determine whether a specific edge between two vertices (c, d) is a bridge.

Note:

An edge is called a bridge if removing it increases the number of connected components of the graph.
if there’s only one path between c and d (which is the edge itself), then that edge is a bridge.*/

class Solution {
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0] , v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        adj.get(c).remove((Integer) d);
        adj.get(d).remove((Integer) c);
        
        boolean[] visited = new boolean[V];
        dfs(c , adj , visited);
        
        return !visited[d];
    }
    private void dfs(int node , List<List<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor , adj , visited);
            }
        }
    }
}
