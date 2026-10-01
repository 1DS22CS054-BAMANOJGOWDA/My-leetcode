class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int i=0;i<n;i++){
            heap.offer(new int[]{matrix[i][0],i,0});
        }
        for(int i=0;i<k;i++){
            int[] current = heap.poll();
            int val = current[0];
            int row = current[1];
            int col = current[2];

            if(col + 1 < n){
                heap.offer(new int[]{matrix[row][col+1],row,col+1});
            }

            if(i == k-1){
                return val;
            }
        }
        return -1;
    }
}