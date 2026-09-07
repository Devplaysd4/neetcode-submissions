class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() >= 2) {

            int max = maxHeap.poll();
            int secondMax = maxHeap.poll();

            if (max > secondMax) {
                maxHeap.add(max - secondMax);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}