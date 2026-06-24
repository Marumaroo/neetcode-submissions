class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqs = new int[26];
        for (char task : tasks) {
            freqs[task - 'A']++;
        }
        
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : freqs) {
            if (freq > 0) max.add(freq);
        }

        Queue<int[]> waiting = new LinkedList<>();
        int time = 0;

        while (!max.isEmpty() || !waiting.isEmpty()) {
            time++;

            if (max.isEmpty()) {
                time = waiting.peek()[1];
            } else {
                int count = max.poll() - 1;

                if (count > 0) {
                    waiting.add(new int[] { count, time + n });
                }
            }

            if (!waiting.isEmpty() && waiting.peek()[1] == time) {
                max.add(waiting.poll()[0]);
            }
        }

        return time;
    }
}
