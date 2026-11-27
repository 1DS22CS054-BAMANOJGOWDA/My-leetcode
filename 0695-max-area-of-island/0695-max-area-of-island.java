class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxarea = 0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    maxarea = Math.max(maxarea,dfs(grid,i,j));
                }
            }
        }
        return maxarea;
    }
    private static int dfs(int[][] grid,int row,int col){
        int rows = grid.length;
        int cols = grid[0].length;

        if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0){
            return 0;
        }
        grid[row][col] = 0;

        return 1 + dfs(grid,row+1,col) + dfs(grid,row-1,col) + dfs(grid,row,col+1) + dfs(grid,row,col-1);
    }
}