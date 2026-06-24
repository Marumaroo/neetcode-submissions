class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for (int n : nums) {
            min.add(n);

            if (min.size() > k) {
                min.poll();
            }
        }

        return min.peek();
    }
}
