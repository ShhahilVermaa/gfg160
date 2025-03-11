/*There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Your task is to count the number of ways, the person can reach the top (order does matter).

*/
class Solution {
    int countWays(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int prev2 = 1 , prev1 = 2;
        int curr = 0;
        
        for(int i = 3 ; i <= n ; i++){
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
