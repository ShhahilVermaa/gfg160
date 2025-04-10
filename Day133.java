/*Given a 2D array houses[][], consisting of n 2D coordinates {x, y} where each coordinate represents the location of each house, the task is to find the minimum cost to connect all the houses of the city.

The cost of connecting two houses is the Manhattan Distance between the two points (xi, yi) and (xj, yj) i.e., |xi – xj| + |yi – yj|, where |p| denotes the absolute value of p.*/

class Solution {

    public int minCost(int[][] houses) {
        int n = houses.length;
        List<int[]> edges = new ArrayList<>();
        
        for(int i = 0 ; i < n ; ++i){
            for(int j = i + 1 ; j < n ; ++j){
                int cost = Math.abs(houses[i][0] - houses[j][0]) + Math.abs(houses[i][1] - houses[j][1]);
                edges.add(new int[]{cost,i,j});
            }
        }
        Collections.sort(edges ,Comparator.comparingInt(a -> a[0]));
        
        int[] parent = new int[n];
        for(int i = 0 ; i < n ; ++i) parent[i] = i;
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        for(int[] edge : edges){
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];
            
            int pu = find(parent , u);
            int pv = find(parent , v);
            
            if(pu != pv){
                parent[pu] = pv;
                totalCost += cost;
                edgesUsed++;
                if(edgesUsed == n-1) break;
            }
        }
        return totalCost;
    }
    private int find(int[] parent , int x){
        if(parent[x] != x)
            parent[x] = find(parent , parent[x]);
            return parent[x];
    }
}
