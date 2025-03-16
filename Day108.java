/*You are given an array arr[] of non-negative numbers. Each number tells you the maximum number of steps you can jump forward from that position.

For example:

If arr[i] = 3, you can jump to index i + 1, i + 2, or i + 3 from position i.
If arr[i] = 0, you cannot jump forward from that position.
Your task is to find the minimum number of jumps needed to move from the first position in the array to the last position.

Note:  Return -1 if you can't reach the end of the array.*/
class Solution {
    static int minJumps(int[] arr) {
        int n = arr.length;
        if(n <= 1) return 0;
        if(arr[0] == 0) return -1;
        
        int maxR = arr[0];
        int s = arr[0];
        int j = 1;
        
        for(int i = 1 ; i < n ; i++){
            if(i == n -1) return j;
            
            maxR = Math.max(maxR, i + arr[i]);
            s--;
            
            if(s == 0){
                j++;
                if(i >= maxR) return -1;
                
                s = maxR - i;
            }
        }
        return -1;
    }
}
