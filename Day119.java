/*You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.

At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.*/

class Solution {
    
    static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int PFneeded = 0 , maxP = 0;
        int i = 0 , j = 0;
        int n = arr.length;
        
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                PFneeded++;
                i++;
            }else{
                PFneeded--;
                j++;
            }
            maxP = Math.max(maxP , PFneeded);
        }
        return maxP;
    }
}
