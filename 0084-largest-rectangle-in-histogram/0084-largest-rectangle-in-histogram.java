class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxarea = 0;
        for(int i=0;i<=heights.length;i++){
            int currentheight = (i == heights.length) ? 0 : heights[i];


            while(!stack.isEmpty() && heights[stack.peek()] > currentheight){

                int height = heights[stack.pop()];
                int leftboundary = stack.isEmpty() ? -1 : stack.peek();

                int width = i - leftboundary - 1;

                int area = height * width;

                maxarea = Math.max(maxarea,area);
            }
            if(i < heights.length){
                stack.push(i);
            }
        }
        return maxarea;
    }
}