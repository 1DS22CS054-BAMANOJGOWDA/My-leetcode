class Solution {
    public String removeDuplicates(String s) {
        char[] res = s.toCharArray(); 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < res.length; i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == res[i]) {
                sb.deleteCharAt(sb.length() - 1); 
            } else {
                sb.append(res[i]); 
            }
        }

        return sb.toString();
    }
}