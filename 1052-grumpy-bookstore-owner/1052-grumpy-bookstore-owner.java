class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int s = 0;

        for(int i=0;i<n;i++){
            if(grumpy[i] == 0){
                s += customers[i];
            }
        }
        int extra = 0;

        for(int i=0;i<minutes;i++){
            if(grumpy[i]==1){
                extra += customers[i];
            }
        }
        int maxextra = extra;
        for(int right=minutes;right<n;right++){
            if(grumpy[right]==1){
                extra += customers[right];
            }

            int left = right-minutes;

            if(grumpy[left] == 1){
                extra -= customers[left];
            }
            maxextra = Math.max(maxextra,extra);
        }
        return s + maxextra;
    }
}