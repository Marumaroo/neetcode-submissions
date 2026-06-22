class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums) {
            freqMap.merge(n, 1, Integer::sum);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        int[] topK = new int[k];
        int idx = 0;

        for (int i=nums.length; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;

            for (int num : buckets[i]) {
                topK[idx++] = num;
                if (idx == k) break;
            }
        }

        return topK;
    }
}
