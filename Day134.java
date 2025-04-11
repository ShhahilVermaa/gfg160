/*Given an undirected, weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by 2d array edges[][], where edges[i]=[u, v, w] represents the edge between the nodes u and v having w edge weight.
You have to find the shortest distance of all the vertices from the source vertex src, and return an array of integers where the ith element denotes the shortest distance between ith node and source vertex src.

Note: The Graph is connected and doesn't contain any negative weight edge.*/

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>>adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            int u = edge[0] , v = edge[1] , w = edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        int[]dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0 ,src});
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currDist = current[0];
            int u = current[1];
            
            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0] , weight = neighbor[1];
                if(dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{dist[v] , v});
                }
            }
        }
        return dist;
    }
}
