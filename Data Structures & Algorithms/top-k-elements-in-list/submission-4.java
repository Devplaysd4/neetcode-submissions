class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for (int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
    
    PriorityQueue<Map.Entry<Integer,Integer>>heap =
        new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());

for (Map.Entry<Integer,Integer> entry:map.entrySet()){
    heap.offer(entry);
    if (heap.size()>k){
        heap.poll();
    }
}
int [] ans = new int[k];
for (int i =0;i<k;i++){
    ans[i]= heap.poll().getKey();

}

return ans;}}