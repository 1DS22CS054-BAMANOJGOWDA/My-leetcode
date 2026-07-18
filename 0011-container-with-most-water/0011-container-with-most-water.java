class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = 0;

        while(left < right){
            int area = (right - left) * Math.min(height[left],height[right]);

            maxWater = Math.max(maxWater,area);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}