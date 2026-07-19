class Solution {
    public int trap(int[] height) {
        int ans = 0, left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                ans += leftMax - height[left++];
            } else {
                rightMax = Math.max(rightMax, height[right]);
                ans += rightMax - height[right--];
            }
        }

        return ans;
    }
}