class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int s : stones) {
            maxHeap.add(s);
        }

        while (maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();

            if (s1 == s2) {
                continue;
            } else {
                maxHeap.add(Math.abs(s2-s1));
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.peek();
    }
}
