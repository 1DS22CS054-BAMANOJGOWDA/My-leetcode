class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int start = 0, end = nums.length - 1;

        // while (start < end) {
        //     int mid = start + (end - start) / 2;

        //     // XOR trick to find if mid is even or odd
        //     if (nums[mid] == nums[mid ^ 1]) {
        //         start = mid + 1; // Move right
        //     } else {
        //         end = mid; // Move left
        //     }
        // }
        // return nums[start]; // Single element found

        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right - left)/2;

            if(mid % 2 == 1){
                mid--;
            }

            if(nums[mid] == nums[mid+1]){
                left = mid + 2;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
