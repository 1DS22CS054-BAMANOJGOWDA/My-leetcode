class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],
        b[1]));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int f = entry.getValue();
            heap.offer(new int[]{num,f});
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = heap.poll()[0];
        }
        return result;
    }
}