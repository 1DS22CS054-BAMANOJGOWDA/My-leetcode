// class MinStack {

//     Deque<Integer> stack = new ArrayDeque<>();
//     Deque<Integer> minstack = new ArrayDeque<>();
//     public MinStack() {
        
//     }
    
//     public void push(int value) {
//         stack.push(value);
//         if(minstack.isEmpty()){
//             minstack.push(value);
//         }else{
//             minstack.push(Math.min(value,minstack.peek()));
//         }
//     }
    
//     public void pop() {
//         stack.pop();
//         minstack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int getMin() {
//         return minstack.peek();
//     }
// }
class MinStack {

    private Deque<int[]> stack = new ArrayDeque<>();

    public MinStack() {
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currentMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currentMin});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */