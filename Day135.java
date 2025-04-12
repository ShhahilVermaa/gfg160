/*You are given a 2D grid image[][] of size n*m, where each image[i][j] represents the color of a pixel in the image. Also provided a coordinate(sr, sc) representing the starting pixel (row and column) and a new color value newColor.

Your task is to perform a flood fill starting from the pixel (sr, sc), changing its color to newColor and the color of all the connected pixels that have the same original color. Two pixels are considered connected if they are adjacent horizontally or vertically (not diagonally) and have the same original color.*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor =  image[sr][sc];
        if(oldColor == newColor) return image;
        dfs(image , sr , sc , oldColor , newColor);
        return image;
    }
    private void dfs(int[][]image , int r , int c ,int oldColor ,int newColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if(image[r][c] != oldColor) return;
        
        image[r][c] = newColor;
        
        dfs(image , r + 1 , c , oldColor , newColor);
        dfs(image , r - 1 , c , oldColor , newColor);
        dfs(image , r , c + 1 , oldColor , newColor);
        dfs(image , r , c-1 , oldColor , newColor);
    }
}
