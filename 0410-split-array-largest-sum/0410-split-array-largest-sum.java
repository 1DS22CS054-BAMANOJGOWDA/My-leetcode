class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for(int num:nums){
            left = Math.max(left,num);
            right += num;
        }
        while(left < right){
            int mid = left + (right - left) / 2;

            int subarrays = 1;
            int currentsum = 0;
            for(int num:nums){
                if(currentsum + num > mid){
                    subarrays++;
                    currentsum = 0;
                }
                currentsum += num;
            }
            if(subarrays <= k){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}