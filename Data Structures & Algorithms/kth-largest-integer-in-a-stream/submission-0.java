class KthLargest {

    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public KthLargest(int k, int[] nums) {

        this.k = k;

        for (int num : nums) {
            add(num);
        }
    }


    public int add(int val) {

        minHeap.add(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}