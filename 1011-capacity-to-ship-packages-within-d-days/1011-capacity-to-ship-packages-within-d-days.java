class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int weight:weights){
            left = Math.max(left,weight);
            right += weight;
        }
        while(left<right){
            int mid = left + (right - left) / 2;
            int day = 1;
            int currentload = 0;
            for(int weight:weights){
                if(weight + currentload > mid){
                    day++;
                    currentload = 0;
                }
                currentload += weight;
            }
            if(day <= days){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}