/*Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][], where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the given adjacency list, and return a list containing the BFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.*/

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        
        
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            bfsTraversal.add(node);
            
            for(int neighbor : adj.get(node)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return bfsTraversal;
    }
}
