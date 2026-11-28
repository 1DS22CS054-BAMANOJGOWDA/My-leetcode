class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int fresh = 0;
        int minutes = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] current = queue.poll();
                for(int[] dir:directions){
                    int rows = current[0] + dir[0];
                    int cols = current[1] + dir[1];

                    if(rows >= 0 && rows < row && cols >= 0 && cols < col && grid[rows][cols] == 1){
                        grid[rows][cols] = 2;
                        fresh--;
                        queue.offer(new int[]{rows,cols});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes:-1;
    }
}