class MedianFinder {

    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianFinder() {
        this.max = new PriorityQueue<>(Collections.reverseOrder());
        this.min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        if (max.size() > min.size() + 1) {
            min.add(max.poll());
        } else if (min.size() > max.size()) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        } else {
            return (min.peek() + max.peek()) / 2.0;
        }
    }
}
