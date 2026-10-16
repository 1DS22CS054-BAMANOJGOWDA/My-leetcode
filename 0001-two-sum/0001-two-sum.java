class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        // //int first = -1;
        // //int last = -1;

        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i] + nums[j] == target){
        //             return new int[] {i,j};
        //         }
        //     }
        // }
        // return new int[] {};
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<n;i++){
            int cop = target - nums[i];
            if(hash.containsKey(cop)){
                return new int[] {hash.get(cop),i};
            }else{
                hash.put(nums[i],i);
            }
        }
        return new int[] {};
    }
}