class Solution {
    public String removeDuplicates(String s) {
        // char[] res = s.toCharArray(); 
        // StringBuilder sb = new StringBuilder();

        // for (int i = 0; i < res.length; i++) {
        //     if (sb.length() > 0 && sb.charAt(sb.length() - 1) == res[i]) {
        //         sb.deleteCharAt(sb.length() - 1); 
        //     } else {
        //         sb.append(res[i]); 
        //     }
        // }

        // return sb.toString();

        Deque<Character> stack = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.removeLast());
        }

        return result.toString();
    }
}