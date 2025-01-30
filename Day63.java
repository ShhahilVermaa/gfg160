// //The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.

class Solution {
    public List<List<Integer>> nQueen(int n) {
        List<List<Integer>> result = new ArrayList<>();
        int[] board = new int[n];
        Arrays.fill(board, -1);
        backtrack(0, board, result, n);
        return result;
    }

    private boolean isSafe(int row, int col, int[] board) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    private void backtrack(int col, int[] board, List<List<Integer>> result, int n) {
        if (col == n) {
            List<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(board[i] + 1);
            }
            result.add(solution);
            return;
        }
        
        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board)) {
                board[col] = row;
                backtrack(col + 1, board, result, n);
                board[col] = -1; // Backtrack
            }
        }
    }
}