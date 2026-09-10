class Solution {

    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Available tasks: highest frequency first
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.add(count);
            }
        }

        // [remaining frequency, available time]
        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            // Move cooled-down task back to available pool
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                int[] entry = cooldown.poll();
                maxHeap.add(entry[0]);
            }

            // Execute highest-frequency available task
            if (!maxHeap.isEmpty()) {

                int count = maxHeap.poll();
                count--;

                if (count > 0) {
                    cooldown.add(new int[]{count, time + n + 1});
                }
            }

            // One CPU cycle passes
            time++;
        }

        return time;
    }
}