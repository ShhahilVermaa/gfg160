/*You are given a set of activities, each with a start time and a finish time, represented by the arrays start[] and finish[], respectively. A single person can perform only one activity at a time, meaning no two activities can overlap. Your task is to determine the maximum number of activities that a person can complete in a day.*/

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][]arr = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = finish[i];
            arr[i][1] = start[i];
        }
        Arrays.sort(arr , (a,b) -> Integer.compare(a[0] , b[0]));
        int fin = -1;
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i][1] > fin){
                ans++;
                fin = arr[i][0];
            }
        }
        return ans;
    }
}
