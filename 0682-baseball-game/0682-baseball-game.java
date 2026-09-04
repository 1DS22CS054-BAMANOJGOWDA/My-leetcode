class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(String op:operations){
            if(op.equals("C")){
                stack.pop();
            }else if(op.equals("D")){
                stack.push(2 * stack.peek());
            }else if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                int sum = first+second;
                stack.push(first);
                stack.push(sum);
            }else{
                stack.push(Integer.parseInt(op));
            }
        }
        int s = 0;
        while(!stack.isEmpty()){
            s += stack.pop();
        }

        return s;
    }
}