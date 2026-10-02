/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.val,b.val));

        for(ListNode list:lists){
            if(list!=null){
                heap.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!heap.isEmpty()){
            ListNode smallest = heap.poll();

            current.next = smallest;
            current = current.next;
            if(smallest.next != null){
                heap.offer(smallest.next);
            } 
        }
        return dummy.next;
    }
}