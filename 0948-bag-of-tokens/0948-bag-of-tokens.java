class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int low = 0;
        int high = tokens.length-1;
        int score = 0;
        int maxscore = 0;

        while(low <= high){
            if(power >= tokens[low]){
                power -= tokens[low];
                low++;
                score++;
                maxscore = Math.max(maxscore,score);
            }else if(score > 0){
                power += tokens[high];
                high--;
                score--;
            }else{
                break;
            }
        }
        return maxscore;
    }
}