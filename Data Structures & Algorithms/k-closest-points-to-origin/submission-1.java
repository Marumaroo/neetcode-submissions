class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> distanceToOrigin(b) - distanceToOrigin(a));

        for (int[] point : points) {
            max.add(point);

            if (max.size() > k) {
                max.poll();
            }
        }

        int[][] kthClosest = new int[k][];

        int i=0;
        while (!max.isEmpty()) {
            kthClosest[i++] = max.poll();
        }

        return kthClosest;
    }

    private int distanceToOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
