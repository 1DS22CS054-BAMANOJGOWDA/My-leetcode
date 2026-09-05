class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans,-1);

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0;i<2*n;i++){
            int index = i % n;
            while(!stack.isEmpty() && nums[stack.peek()] < nums[index]){
                int prev = stack.pop();
                ans[prev] = nums[index];
            }
            if(i < n){
                stack.push(i);
            }
        }
        return ans;
    }
}