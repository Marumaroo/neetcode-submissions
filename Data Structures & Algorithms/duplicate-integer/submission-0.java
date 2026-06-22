class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int n : nums) {
            if (seen.contains(n)) {
                return true;
            } else {
                seen.add(n);
            }
        }

        return false;
    }
}