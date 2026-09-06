class Solution {
    public String removeKdigits(String num, int k) {
       Deque<Character> stack = new ArrayDeque<>();

       for(char digit : num.toCharArray()){
        while(!stack.isEmpty() && k > 0 && stack.peek() > digit){
            stack.pop();
            k--;
        } 
        stack.push(digit);
       }

       while(k > 0){
        stack.pop();
        k--;
       }

       StringBuilder sb = new StringBuilder();
       while(!stack.isEmpty()){
        sb.append(stack.removeLast());
       }
       int index = 0;

       while(index < sb.length() && sb.charAt(index) == '0'){
        index++;
       }
       sb = new StringBuilder(sb.substring(index));

       return sb.length() == 0 ? "0" : sb.toString();
    }
}