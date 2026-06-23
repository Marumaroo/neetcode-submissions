class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int limit;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.limit = k;

        for (int n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > limit) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
