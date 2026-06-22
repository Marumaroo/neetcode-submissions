class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int n : nums) {
            seen.add(n);
        }

        int max = 0;
        for (int n : seen) {
            if (!seen.contains(n - 1)) {
                int length = 0;
                while (seen.contains(n + length)) {
                    length++;
                }
                max = Math.max(max, length);
            }
        }

        return max;
    }
}
