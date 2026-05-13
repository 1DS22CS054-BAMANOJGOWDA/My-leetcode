class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left=0;
        int sum=0;
        Set<Integer> set = new HashSet<>();
        int maxsum=0;

        for(int right=0;right<nums.length;right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);

            sum += nums[right];
            maxsum = Math.max(maxsum,sum);
        }
        return maxsum;
    }
}