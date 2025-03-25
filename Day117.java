/*You are given a boolean expression s containing
    'T' ---> true
    'F' ---> false 
and following operators between symbols
   &   ---> boolean AND
    |   ---> boolean OR
   ^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Note: The answer is guaranteed to fit within a 32-bit integer.*/

class Solution {
    
    static int countWays(String s) {
        int n = s.length();
        int[][]dpTrue = new int[n][n];
        int[][]dpFalse = new int[n][n];
        
        for(int i = 0 ; i < n ; i += 2)
        {
            if(s.charAt(i) == 'T'){
                dpTrue[i][i] = 1;
                dpFalse[i][i] = 0;
            }else{
                dpTrue[i][i] = 0;
                dpFalse[i][i] = 1;
            }
        }
        for(int len = 3 ; len <= n ; len += 2){
            for(int i = 0 ; i <= n-len; i += 2){
                int j = i + len - 1;
                for(int k =i+1 ; k < j ; k+= 2){
                    char op = s.charAt(k);
                    
                    if(op == '&'){
                        dpTrue[i][j] += dpTrue[i][k-1] * dpTrue[k+1][j];
                        dpFalse[i][j] += dpTrue[i][k-1] * dpFalse[k+1][j] +
                                         dpFalse[i][k-1] * dpTrue[k+1][j] +
                                         dpFalse[i][k-1] * dpFalse[k+1][j];
                    }else if(op == '|'){
                        dpTrue[i][j] += dpTrue[i][k-1] * dpTrue[k+1][j] +
                                        dpTrue[i][k-1] * dpFalse[k+1][j] +
                                        dpFalse[i][k-1] * dpTrue[k+1][j];
                        dpFalse[i][j] += dpFalse[i][k-1] * dpFalse[k+1][j];
                    }else if(op == '^'){
                        dpTrue[i][j] += dpTrue[i][k-1] * dpFalse[k+1][j] +
                                        dpFalse[i][k-1] * dpTrue[k+1][j];
                        dpFalse[i][j] += dpTrue[i][k-1] * dpTrue[k+1][j] +
                                         dpFalse[i][k-1] * dpFalse[k+1][j];
                    }
                }
            }
        } 
        
        return dpTrue[0][n-1];
        
    }
}
