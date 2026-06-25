class Solution {
    public int rob(int[] nums) {
        int n1 = 0, n2 = nums[0];

        for (int i=1; i<nums.length; i++) {
            int temp = n2;
            n2 = Math.max(n2, n1 + nums[i]);
            n1 = temp;
        }

        return n2;
    }
}
