class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m * k > bloomDay.length){
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while(left < right){
            int mid = left + (right - left) / 2;
            if(canmake(bloomDay,m,k,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canmake(int[] bloomDay,int m,int k,int day){
        int consecutive = 0;
        int bouq = 0;
        for(int flower:bloomDay){
            if(flower <= day){
                consecutive++;
                if(consecutive == k){
                    bouq++;
                    consecutive=0;
                }
            }else{
                consecutive = 0;
            }
        }
        return bouq >= m;
    }
}