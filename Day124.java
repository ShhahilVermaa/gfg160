/*Given a connected undirected graph represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0, visiting vertices from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.*/
class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[]visited =  new boolean[adj.size()];
        
        dfsHelper(0 , adj , visited , result);
        return result;
        
    }
    private void dfsHelper(int node , ArrayList<ArrayList<Integer>> adj,boolean[] visited , ArrayList<Integer>result){
        visited[node] = true;
        result.add(node);
        
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfsHelper(neighbour , adj , visited , result);
            }
        }
    }
}
