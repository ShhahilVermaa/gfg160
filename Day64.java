// //Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

// A sudoku solution must satisfy all of the following rules:

// 1. Each of the digits 1-9 must occur exactly once in each row.
// 2. Each of the digits 1-9 must occur exactly once in each column.
// 3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat);
    }
    
    private static boolean solve(int[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == 0){
                    for(int num = 1; num <= 9; num++){
                        if(isValid(board, row, col, num)){
                            board[row][col] = num;
                            if(solve(board)){
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValid(int[][] board, int row, int col, int num){
        for(int i=0; i < 9; i++){
            if(board[row][i] == num || board[i][col] == num || 
            board[row - row%3 + i / 3][col - col%3 + i%3] == num){
                return false;
            }
        }
        return true;
    }
}