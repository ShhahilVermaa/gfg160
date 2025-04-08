/*You are given an undirected graph with V vertices and E edges. The graph is represented as a 2D array edges[][], where each element edges[i] = [u, v] indicates an undirected edge between vertices u and v.
Your task is to return all the articulation points (or cut vertices) in the graph.
An articulation point is a vertex whose removal, along with all its connected edges, increases the number of connected components in the graph.

Note: The graph may be disconnected, i.e., it may consist of more than one connected component.
If no such point exists, return {-1}.*/
class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[V];
        for(int i = 0 ; i < V ; i++) adj[i] = new ArrayList<>();
        for(int[]edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[]disc = new int[V];
        int[]low = new int[V];
        int[]parent = new int[V];
        boolean[]visited = new boolean[V];
        boolean[]ap = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < V ; i++) parent[i] = -1;
        
        int time = 0;
        
        for(int i = 0 ; i < V ; i++){
            if(!visited[i]){
                dfs(i , time , disc , low , parent , visited , ap , adj);
            }
        }
        for(int i = 0 ; i < V ; i++){
            if(ap[i]) res.add(i);
        }
        if(res.isEmpty()) res.add(-1);
        return res;
    }
    static void dfs(int u , int time ,int[] disc ,int[] low ,int[] parent ,boolean[] visited ,boolean[] ap ,ArrayList<Integer>[] adj){
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        
        for(int v : adj[u]){
            if(!visited[v]){
                children++;
                parent[v] = u;
                dfs(v , time , disc , low , parent , visited , ap , adj);
                
                low[u] = Math.min(low[u] , low[v]);
                
                if(parent[u] == -1 && children > 1) ap[u] = true;
                if(parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            }else if(v != parent[u]){
                low[u] = Math.min(low[u] , disc[v]);
            }
        }
    }
}
