/*Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
Determine the maximum amount he can loot.*/

class Solution {
    public int findMaxSum(int arr[]) {
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        
        int prev2 = 0;
        int prev1 = arr[0];
        
        for(int i = 1 ; i < n ; i++){
            int pick = arr[i] + prev2;
            int skip = prev1;
            int curr = Math.max(pick , skip);
            
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
